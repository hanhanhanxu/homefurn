package hx.insist.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderinfoVo;
import hx.insist.mapper.*;
import hx.insist.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderinfoServiceImpl implements OrderinfoService {

    @Autowired
    private OrderinfoMapper orderinfoMapper;
    @Autowired
    private SuitMapper suitMapper;
    @Autowired
    private CollocationMapper collocationMapper;
    @Autowired
    private OrderitemsMapper orderitemsMapper;
    @Autowired
    private FittingService fittingService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private FittingStockService fittingStockService;

    @Override
    public void addOrder(String sid) {
        System.out.println("测试来了*************************************************************");
        /**1、修改suit表中的ssign
         * 2、增加一条订单记录
         *      1、向orderinfo表中添加记录
         *          1、查询地址组装收货信息
         *      2、向orderitems表中添加记录
         *      3、增加相应家居的销量
         *      4、减少相应家居的库存
         *
         */
        //通过sid查询出来这条装饰的全部信息
        Suit suit = suitMapper.selectByPrimaryKey(sid);
        //System.out.println("service层addOrder() suit:"+suit);
        String uid = suit.getUid();

        //一、组装orderinfo 并添加数据记录
            //1、查询此人的默认收货地址 拼接总地址ofaddress
            Address address = addressMapper.selectMoAddress(suit.getUid());
            String ofaddress = address.getRpro()+address.getRcity()+address.getRarea()+address.getRinfo();
            //System.out.println("ofaddress:"+ofaddress);
            //2、生成订单号
            //获取年月日
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
            String strdate = format.format(date);
            //编辑uid
            String uids = uid.replace("-","");
            //生成：年月日+uid+5位随机数
            String ofserial = strdate + uids + UUID.randomUUID().toString().substring(0,5);
            //System.out.println("ofserial:"+ofserial);
            //开始组装orderinfo
            Orderinfo orderinfo = new Orderinfo();
            String ofid = UUID.randomUUID().toString();
            orderinfo.setOfid(ofid);
            orderinfo.setOfserial(ofserial);
            orderinfo.setUid(uid);
            orderinfo.setRid(address.getRid());
            orderinfo.setRname(address.getRname());
            orderinfo.setRtel(address.getRtel());
            orderinfo.setOfaddress(ofaddress);
            orderinfo.setOfprice(suit.getSprice());
            orderinfo.setOftime(date);
            orderinfo.setOfstate("待发货");
            //System.out.println("orderinfo:"+orderinfo);
            orderinfoMapper.insert(orderinfo);

        //二、组装orderitems 并添加数据记录
        List<Collocation> list = collocationMapper.selectCollocationBySid(sid);
        for(Collocation collocation:list){
            Orderitems orderitems = new Orderitems();
            orderitems.setOsid(UUID.randomUUID().toString());
            orderitems.setOfid(ofid);
            orderitems.setFid(collocation.getFid());
            orderitems.setFname(collocation.getFname());
            orderitems.setFprice(collocation.getFprice());
            orderitems.setFnum(1);
            orderitems.setFpay(collocation.getFprice().multiply(BigDecimal.valueOf(1)));

            //添加相应家居的销量
            fittingService.addFsvolume(collocation.getFid());
            //减少相应库存
            fittingStockService.reduceByFid(collocation.getFid());

            orderitemsMapper.insert(orderitems);
        }
        suitMapper.updateSsign(sid);
    }

    @Override
    public List<Orderinfo> getAllByUid(String uid) {
        List<Orderinfo> list = orderinfoMapper.selectAllByUid(uid);
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public List<Orderinfo> getAllByUidAndOfstate(String uid, String string) {
        List<Orderinfo> list = orderinfoMapper.selectAllByUidAndOfstate(uid,string);
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public PageInfo<OrderinfoVo> getAll(int currentPage, int pageSize) {
        //作为前台显示信息
        List<OrderinfoVo> orderinfoVoList = new ArrayList<>();

        PageHelper.startPage(currentPage, pageSize);
        //PageHelper.startPage 的下一个查询将会是分页查询。
        List<Orderinfo> orderinfoList = orderinfoMapper.selectAll();//所有订单信息
        if (!orderinfoList.isEmpty()){
            for(Orderinfo orderinfo:orderinfoList){//对于每个订单
                //根据每个orderinfo查询出每个list<orderitems集合> 订单详情
                List<Orderitems> orderitemsList = orderitemsMapper.selectAllByOfid(orderinfo.getOfid());

                //利用orderinfo和orderitems包装OrderinfoVo
                OrderinfoVo orderinfoVo = new OrderinfoVo();
                orderinfo.setStroftime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderinfo.getOftime()));
                orderinfoVo.setOrderinfo(orderinfo);
                orderinfoVo.setOrderitemsList(orderitemsList);

                //把每一个订单（与其详情的组合）信息放入 包装的OrderVoList集合
                orderinfoVoList.add(orderinfoVo);
            }
        }
        PageInfo<OrderinfoVo> pageInfo = new PageInfo(orderinfoVoList);
        return pageInfo;
    }

    @Override
    public PageInfo<OrderinfoVo> getAllByOfstate(int currentPage, int pageSize, String string) {
        //作为前台显示信息
        List<OrderinfoVo> orderinfoVoList = new ArrayList<>();

        PageHelper.startPage(currentPage, pageSize);
        //PageHelper.startPage 的下一个查询将会是分页查询。
        List<Orderinfo> orderinfoList = orderinfoMapper.selectAllByOfstate(string);//所有订单信息
        if (!orderinfoList.isEmpty()){
            for(Orderinfo orderinfo:orderinfoList){//对于每个订单
                //根据每个orderinfo查询出每个list<orderitems集合> 订单详情
                List<Orderitems> orderitemsList = orderitemsMapper.selectAllByOfid(orderinfo.getOfid());

                //利用orderinfo和orderitems包装OrderinfoVo
                OrderinfoVo orderinfoVo = new OrderinfoVo();
                orderinfo.setStroftime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderinfo.getOftime()));
                orderinfoVo.setOrderinfo(orderinfo);
                orderinfoVo.setOrderitemsList(orderitemsList);

                //把每一个订单（与其详情的组合）信息放入 包装的OrderVoList集合
                orderinfoVoList.add(orderinfoVo);
            }
        }
        PageInfo<OrderinfoVo> pageInfo = new PageInfo(orderinfoVoList);
        return pageInfo;
    }

    @Override
    public void orderByOfid(String ofid) {
        orderinfoMapper.updateOfstate1ByOfid(ofid);
    }

    @Override
    public void receiveByOfid(String ofid) {
        orderinfoMapper.updateOfstate2ByOfid(ofid);
    }
}
