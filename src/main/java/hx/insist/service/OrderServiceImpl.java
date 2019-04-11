package hx.insist.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderVo;
import hx.insist.mapper.*;
import hx.insist.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SuitMapper suitMapper;
    @Autowired
    private CollocationMapper collocationMapper;
    @Autowired
    private OrderitemMapper orderitemMapper;
    @Autowired
    private FittingService fittingService;
    @Autowired
    private UserMapper userMapper;


    @Override
    public void addOrder(String sid) {
        //通过sid查询出来这条装饰的全部信息
        Suit suit = suitMapper.selectByPrimaryKey(sid);
        System.out.println("service层suit。。。。。。。。:"+suit);
        //组装order
        Order order = new Order();
        String oid = UUID.randomUUID().toString();
        order.setOid(oid);
        System.out.println("oid:"+oid);
        order.setUid(suit.getUid());
        order.setOtime(new Date());//下单时间
        order.setOstate(new Integer(0));//订单状态。0，表示未发货
        order.setOprice(suit.getSprice());//订单总价

        //向order表中添加记录
        System.out.println("service层order。。。。。。。。:"+order);
        orderMapper.insert(order);
        System.out.println("成功添加。。。。。。。。");

        //向orderitem表中添加记录  遍历collocation表  添加到orderitem表
        List<Collocation> list = collocationMapper.selectCollocationBySid(sid);
        for(Collocation collocation:list){
            Orderitem orderitem = new Orderitem();
            orderitem.setOiid(UUID.randomUUID().toString());
            orderitem.setFid(collocation.getFid());
            orderitem.setFname(collocation.getFname());
            orderitem.setFprice(collocation.getFprice());
            orderitem.setOid(oid);
            //添加相应家居的销量
            fittingService.addFsvolume(collocation.getFid());

            orderitemMapper.insert(orderitem);
        }
        //修改suit表中的Ssign
        suitMapper.updateSsign(sid);

    }

    /*@Override
    public void addOrder(Order order) {
        orderMapper.insert(order);
    }*/

    @Override
    public List findByUid(String uid) {
        List list = orderMapper.selectByUid(uid);
        if (list.isEmpty())
            return null;
        return list;
    }

    @Override
    public PageInfo<OrderVo> fingAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        //PageHelper.startPage 的下一个查询将会是分页查询。
        List<Order> list = orderMapper.selectAll();

        List<OrderVo> orderVoList = new ArrayList<>();
        if (!list.isEmpty()){
            System.out.println("查询不为空.................");
            //包装OrderVoList     用于展示前台页面
            for(Order order:list){
                //根据每个order查询出每个list<orderitem集合>
                List<Orderitem> list1 = orderitemMapper.selectByOid(order.getOid());
                //利用order和orderitem包装OrderVo
                OrderVo orderVo = new OrderVo();
                orderVo.setOid(order.getOid());
                orderVo.setUid(order.getUid());

                User u = (User)userMapper.selectByPrimaryKey(order.getUid());
                orderVo.setUsername(u.getUsername());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String datetime = simpleDateFormat.format(order.getOtime());
                orderVo.setOtime(datetime);
                orderVo.setOprice(order.getOprice());
                orderVo.setOrderitems(list1);
                //把每一个订单（与其详情的组合）信息放入 包装的OrderVoList集合
                orderVoList.add(orderVo);
            }
        }
        PageInfo<OrderVo> pageInfo = new PageInfo(orderVoList);
        return pageInfo;
    }

}
