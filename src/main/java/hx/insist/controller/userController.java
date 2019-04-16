package hx.insist.controller;

import hx.insist.Vo.CollocationVo;
import hx.insist.Vo.CommentVo;
import hx.insist.Vo.SuitVo;
import hx.insist.pojo.Collocation;
import hx.insist.pojo.Comment;
import hx.insist.pojo.Suit;
import hx.insist.pojo.User;
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




    //退出登录
    @RequestMapping("/logoff")
    public String logoff(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/fitting/index";
    }

    @RequestMapping("/info")
    public String info(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        return "/WEB-INF/jsp/info.jsp";
    }

    @RequestMapping("/modifyInfo")
    public String modifyInfo(HttpServletRequest request,User user,String password2){
        System.out.println(user);
        User u = (User) request.getSession().getAttribute("user");//获取session中的user

        //修改nickname intro
        if(password2==null || "".equals(password2)){
            if(!user.Verification3()){
                request.setAttribute("error",user.getErrors());
                return "/WEB-INF/jsp/info.jsp";
            }else{
                //修改
                u.setNickname(user.getNickname());
                u.setIntro(user.getIntro());
                userService.modifyByUid(u);
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
        request.getSession().setAttribute("user",u);
        //修改完成回到myinfo界面
        return "/WEB-INF/jsp/myinfo.jsp";
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

    //进入我的
    @RequestMapping("/myinfo")
    public String myinfo(HttpSession session,HttpServletRequest request){
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
        request.getSession().setAttribute("suitVoList",suitVoList);


        //我的订单
        //通过uid查询 装饰信息      从suit表中查询
        List<Suit> listsuitOrdered = suitService.QueryAllByUidOrdered(u.getUid());
        //通过装饰信息 储存每条装饰中的家居信息
        List<SuitVo> suitVoListOrdered = new ArrayList<>();//里面装的集合是List<CollocationVo>
        if(listsuitOrdered!=null){
            for(Suit suit:listsuitOrdered){
                //第一套装饰里面的家居几个  第二套  第三套
                List<CollocationVo> listc = collocationService.findCollocationBySid(suit.getSid());

                SuitVo suitVo = new SuitVo();
                suitVo.setCollocations(listc);
                suitVo.setSid(suit.getSid());
                suitVo.setSname(suit.getSname());
                suitVo.setSprice(suit.getSprice());

                suitVoListOrdered.add(suitVo);
            }
        }
        request.getSession().setAttribute("order",suitVoListOrdered);

        return "/WEB-INF/jsp/myinfo.jsp";
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
    @RequestMapping("/QuerySuit/{uid}")
    public String QuerySuit(@PathVariable("uid") String uid , HttpServletRequest request){
        List<Suit> list = suitService.QueryAllByUid(uid);
        System.out.println("uid:"+uid);
        for(Suit suit:list){
            System.out.println(suit);
        }
        request.setAttribute("suits",list);//sid uid sname
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
        orderService.addOrder(sid);
        return "/user/myinfo";
    }

}