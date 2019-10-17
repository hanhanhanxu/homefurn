package hx.insist.controller;

import hx.insist.Vo.*;
import hx.insist.pojo.*;
import hx.insist.service.*;
import hx.insist.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private SuitService suitService;
    @Autowired
    private CollocationService collocationService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderinfoService orderinfoService;
    @Autowired
    private OrderitemsService orderitemsService;
    @Autowired
    private FittingService fittingService;

    //进入我的
    @RequestMapping("/myinfo")
    public String myinfo(HttpSession session){
        User u = (User) session.getAttribute("user");
        System.out.println(u);

        //我的装饰套装
        //通过uid查询 装饰信息      从suit表中查询
        List<Suit> listsuit = suitService.QueryAllByUid(u.getUid());
        //通过装饰信息 储存每条装饰中的家居信息
        List<SuitVo> suitVoList = new ArrayList<>();//里面装的集合是List<CollocationVo>
        if(listsuit!=null){
            for(Suit suit:listsuit){
                //第一套装饰里面的家居几个  第二套  第三套
                List<CollocationVo> listc = collocationService.findCollocationBySid(suit.getSid());
                SuitVo suitVo = new SuitVo();
                suitVo.setCollocations(listc);
                suitVo.setSid(suit.getSid());
                suitVo.setSname(suit.getSname());
                suitVo.setSprice(suit.getSprice());

                suitVoList.add(suitVo);
            }
        }
        session.setAttribute("suitVoList",suitVoList);


        //我的订单
        /**
         * 装饰名 总价 收货人 电话 地址 下单时间 订单状态 订单号
         * 订单详情 家居图片 名字 价格
         */
        //待发货订单
        cunList(session,u,"待发货","order");
        //待收货订单
        cunList(session,u,"已发货","order2");

        //已收货订单
        cunList(session,u,"已收货","order3");

        //加载此人是否有默认地址
        Address address = addressService.getMoByUid(u.getUid());
        session.setAttribute("address",address);
        return "/WEB-INF/jsp/myinfo.jsp";
    }

    private void cunList(HttpSession session,User u,String string,String sessionlist){
        //放在session中前台显示的信息 orderinfoVoList<OrderinfoVo>
        List<OrderinfoVo> orderinfoVoList = new ArrayList<>();
        // 查出此用户所有订单
        List<Orderinfo> listOrderinfo = orderinfoService.getAllByUidAndOfstate(u.getUid(),string);
        if(listOrderinfo!=null){
            //找出每个订单中
            for(Orderinfo orderinfo:listOrderinfo){
                //找出当前订单的详细信息 都买了啥
                List<Orderitems> listOrderitems = orderitemsService.getAllOrderinfoByOfid(orderinfo.getOfid());
                if(listOrderitems!=null){
                    List<OrderitemsVo> orderitemsVoList = new ArrayList<>();
                    //遍历listOrderitems 组成新的orderitemsVoList
                    for(Orderitems orderitems:listOrderitems){
                        OrderitemsVo orderitemsVo = new OrderitemsVo();
                        orderitemsVo.setOrderitems(orderitems);
                        orderitemsVo.setFimg(fittingService.getFimgByFid(orderitems.getFid()));

                        orderitemsVoList.add(orderitemsVo);
                    }
                    OrderinfoVo orderinfoVo = new OrderinfoVo();
                    orderinfo.setStroftime(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(orderinfo.getOftime()));
                    orderinfoVo.setOrderinfo(orderinfo);//当前订单信息
                    orderinfoVo.setOrderitemsVoList(orderitemsVoList);//当前订单详情

                    orderinfoVoList.add(orderinfoVo);//将上述orderinfoVo 添加到容器中
                }
            }
        }
        System.out.println(orderinfoVoList.size());
        session.setAttribute(sessionlist,orderinfoVoList);
    }

    //退出登录
    @RequestMapping("/logoff")
    public String logoff(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/fitting/index";
    }


    //去修改个人信息页面
    @RequestMapping("/info")
    public String info(){
        /*User user = (User) session.getAttribute("user");
        System.out.println(user);*/

        return "/WEB-INF/jsp/info.jsp";
    }


    //修改个人信息请求
    @RequestMapping("/modifyInfo")
    public String modifyInfo(HttpServletRequest request,HttpSession session,User user,String password2){
        System.out.println(user);
        User u = (User) session.getAttribute("user");//获取session中的user

        //修改nickname intro
        if(password2==null || "".equals(password2)){
            if(!user.Verification3()){
                request.setAttribute("error",user.getErrors());
                return "/WEB-INF/jsp/info.jsp";
            }else{
                try{
                    //修改
                    u.setNickname(user.getNickname());
                    u.setIntro(user.getIntro());
                    userService.modifyByUid(u);
                }catch (Exception e){

                }
            }
        }else{//修改nickname password intro
            if(!user.Verification2(password2)){
                request.setAttribute("error",user.getErrors());
                return "/WEB-INF/jsp/info.jsp";
            }else{
                u.setNickname(user.getNickname());
                u.setPassword(WebUtil.md5(user.getPassword()));
                u.setIntro(user.getIntro());
                userService.modifyByUid(u);
            }
        }

        System.out.println("更新之后的user:"+u);
        //更新session中的user信息
        session.setAttribute("user",u);
        //修改完成回到myinfo界面
        return "/WEB-INF/jsp/myinfo.jsp";
    }


    //去设置地址页面
    @RequestMapping("/address")
    public String address(HttpSession session){
        User u = (User) session.getAttribute("user");
        //查询已存在的收货地址，展示出来
        List<Address> list = addressService.getAllByUid(u.getUid());
        session.setAttribute("addresses",list);
        System.out.println(list.size());
        return "/WEB-INF/jsp/address.jsp";
    }


    //设置地址 请求
    @RequestMapping("/editaddress")
    public String editaddress(Address address,String mo,HttpSession session){
        User u = (User) session.getAttribute("user");
        address.setUid(u.getUid());
        if("true".equals(mo)){//是
            address.setRmo(1);//默认收货地址
            //把其他设置为非默认地址
            addressService.updateMo(u.getUid());
        }else{//否
            if(addressService.getCountMo(u.getUid())!=0)//存在默认地址的画
                address.setRmo(0);//设置为非默认
            else//没有其他默认地址
                address.setRmo(1);//设置为默认收货地址
        }
        addressService.add(address);
        System.out.println(address);
        return "/user/address";
    }

    //删除地址
    @RequestMapping("/deleteAddress/{rid}")
    public String deleteAddress(@PathVariable String rid,HttpSession session){
        User u = (User) session.getAttribute("user");
        //删除之前先查出来其他收货地址中的 一个   也可能没有
        Address address = addressService.getOtherByUid(u.getUid(),rid);


        //删除之前判断是否为默认地址
        String rmo = addressService.queryMo(rid);
        if("1".equals(rmo)){//如果要删除的这个是默认的收货地址
            //就随便选一个其他的地址作为默认收货地址
            if(address!=null)
                addressService.setMo(address.getRid());
        }
        //删除
        addressService.deleteByRid(rid);
        return "/user/address";
    }

    //将rid设为默认地址
    @RequestMapping("/updateAddressMo/{rid}")
    public String updateAddressMo(@PathVariable String rid,HttpSession session){
        //先将已存在的默认地址设置为非默认
        User u = (User) session.getAttribute("user");
        addressService.updateMo(u.getUid());
        //将此rid设置为默认地址
        addressService.setMo(rid);
        return "/user/address";
    }


    //发表评论
    @RequestMapping("/comment")
    public String comment(Comment comment, HttpSession session){
        System.out.println(comment);
        commentService.addComment(comment);//向表中添加评论
        List<Comment> list = commentService.findAllByFid(comment.getFid());
        if(list!=null) {
            List<CommentVo> listVo = new ArrayList();
            for (Comment c : list) {//因为查询出来的list里的Comment的ctime类型均为Date类型，在网页展示不好。所以全部换为时间字符串可在网页展示
                CommentVo commentVo = new CommentVo();
                //commentVo.setCid(c.getCid());
                commentVo.setNickname(c.getNickname());
                commentVo.setContent(c.getContent());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                commentVo.setCtime(sdf.format(c.getCtime()));

                listVo.add(commentVo);
            }
            session.setAttribute("comments",listVo);
        }
        return "/intro.jsp";
    }



    //创建装饰  向搭配表suit中添加数据
    @RequestMapping("/addSuit")
    public String addSuit(String uid, Suit suit,
                          HttpServletRequest request){
        if(suit!=null){
            suitService.addSuit(suit);
        }
        return "/user/myinfo";
    }

    //删除装饰
    @RequestMapping("/delSuit")
    public String delSuit(String sid){
        suitService.delSuit(sid);//配置表中的内容  级联删除了
        return "/user/myinfo";
    }


    //通过uid查询此人的所有装饰   查询搭配表
    @RequestMapping("/QuerySuit")
    public String QuerySuit(HttpServletRequest request,HttpSession session){
        /*User u = (User) session.getAttribute("user");
        if(u!=null){
            String uid = u.getUid();
            List<Suit> list = suitService.QueryAllByUid(uid);
            request.setAttribute("suits",list);//sid uid sname
        }*/
        return "/intro.jsp";
    }

   //查询一个装饰的所有配置
   @RequestMapping("/QueryCollocation")
    public String QueryCollocation(String sid,HttpServletRequest request){
        List list = collocationService.findCollocationBySid(sid);
        request.setAttribute("collocations",list);
        return "";
    }

    //选中某个装饰套装，向装饰中添加家居    向配置表中添加数据，更新搭配表总价
    @RequestMapping("/addCollocation")
    public String addCollocation(Collocation collocation ,HttpServletRequest request){
        System.out.println(collocation);
        if(collocation.getSid()!=null ){//只有选中了某个  装饰套装  sid 才有值
            collocationService.addCollocation(collocation);//添加配置表，更新搭配表的总价
            request.setAttribute("msg","添加成功！");
        }
        return "/intro.jsp";
    }


    //通过cid删除某个装饰中的一个家居
    @RequestMapping("/delCollocation/{cid}")
    public String delCollocation(@PathVariable("cid")String cid){
        System.out.println(cid);
        collocationService.delCollocation(cid);
        return "/user/myinfo";
    }


    //删除装饰中的某个家居    删除配置表中的一条记录
    @RequestMapping("/delCollocations/{cid}")
    public String delCollocations(@PathVariable("cid") String cid){
        String [] str = cid.split("&");
        for(int i=0;i<str.length;i++){
            //删除 家居     service里更改了suit表的总价
            collocationService.delCollocation(str[i]);
        }
        return "/user/myinfo";
    }

    //添加订单
    @RequestMapping("/orderSuit")
    public String orderSuit(String sid){
        //订购
        /**1、修改suit表中的ssign
         * 2、增加一条订单记录
         *      1、向order表中添加记录
         *      2、向orderitem表中添加记录
         *      3、增加相应家居的销量
         */
        //orderService.addOrder(sid);

        /**1、修改suit表中的ssign
         * 2、增加一条订单记录
         *      1、向orderinfo表中添加记录
         *          1、查询地址组装收货信息
         *      2、向orderitems表中添加记录
         *      3、增加相应家居的销量
         *      4、减少相应家居的库存
         *
         */
        orderinfoService.addOrder(sid);
        return "/user/myinfo";
    }

    @RequestMapping("/receiveGoods")
    public String receiveGoods(String ofid){
        orderinfoService.receiveByOfid(ofid);
        return "/user/myinfo";
    }
}