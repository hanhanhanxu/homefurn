package hx.insist.controller;

import com.github.pagehelper.PageInfo;
import hx.insist.Vo.CommentVo;
import hx.insist.Vo.FittingDetail;
import hx.insist.pojo.*;
import hx.insist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fitting")
public class fittingController {

    @Autowired
    private FittingService fittingService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private StyleService styleService;
    @Autowired
    private LunboService lunboService;
    @Autowired
    private SuitService suitService;

    @RequestMapping("/index")//加载首页  种类、风格 信息
    public String index(HttpSession session){
        //加载种类、风格信息
        List listType = typeService.findAllType();
        List listStyle = styleService.findAllStyle();
        session.setAttribute("type",listType);
        session.setAttribute("style",listStyle);

        //将session域中的筛选信息去掉
        session.removeAttribute("fstyle");
        session.removeAttribute("ftype");

        //加载轮播图
        List<Lunbo> lunbopics = lunboService.selectAll();
        session.setAttribute("lunbopics",lunbopics);

        //加载热销榜
        List<Fitting> list3 = fittingService.findTop(3);
        session.setAttribute("topfittings",list3);

        //加载家居
        return "/fitting/fittings";
    }

    //查询
    @RequestMapping("/search/{str}")
    public String search(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false, defaultValue = "10") Integer PageSize,
                         @PathVariable("str") String str,
                         HttpServletRequest request,HttpSession session){

        if(session.getAttribute("admin")!=null){
            PageSize = 12;
        }

        //String str = (String) request.getAttribute("str");
        System.out.println("str:"+str);
        if(str.length()!=0){
            System.out.println("search查询if语句");
            PageInfo pageInfo = fittingService.findOverall(pageNum,PageSize,str);
            session.setAttribute("pageInfo",pageInfo);
            return "/menu.jsp";
        }else {
            System.out.println("search查询else语句，查询条件为空");
            return "/fitting/index";
        }
    }


    //加载家居
    //分页展示  首页加载
    @RequestMapping("/fittings")//findAll    pageNum当前页   PageSize页的大小
    public String fittings(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false, defaultValue = "10") Integer PageSize,
                           HttpSession session) {

        if(session.getAttribute("admin")!=null){
            PageSize = 12;
        }

        //取得 条件筛选 信息
        String fstyle = (String) session.getAttribute("fstyle");
        String ftype = (String) session.getAttribute("ftype");
        //如果是进入网站首页，没有选择 条件筛选 信息 ，则fstyle和ftype都为null

        System.out.println("fstyle:"+fstyle);
        System.out.println("ftype:"+ftype);

        try{
            PageInfo pageInfo;

            if(fstyle!=null && ftype!=null){//种类 且 风格 全不为空
                if("全部".equals(fstyle) && "全部".equals(ftype)){//全部 全部
                    pageInfo = fittingService.fingAll(pageNum,PageSize);
                }else if(!"全部".equals(fstyle) && !"全部".equals(ftype)){//都不为 全部
                    System.out.println("正常进入。。。。。。。。。。");
                    pageInfo = fittingService.fingByCondition(pageNum,PageSize,ftype,fstyle);
                }else if ("全部".equals(fstyle) && !"全部".equals(ftype)){//至少有一个条件  ftype
                    pageInfo = fittingService.fingByFtype(pageNum,PageSize,ftype);
                }else if("全部".equals(ftype) && !"全部".equals(fstyle)){//至少有一个条件  fstyle
                    pageInfo = fittingService.fingByFstyle(pageNum,PageSize,fstyle);
                }else {
                    pageInfo = fittingService.fingAll(pageNum,PageSize);
                }
            }else{//种类和风格 全为空
                pageInfo = fittingService.fingAll(pageNum,PageSize);
            }

            session.setAttribute("pageInfo",pageInfo);
        }catch (Exception e){
            System.out.println("userController中的fittings异常信息:");
            e.printStackTrace();
        }

        if(session.getAttribute("admin")!=null){
            return "/WEB-INF/jsp/adminmenu.jsp";//列表页面
        }else {
            return "/menu.jsp";//列表页面
        }
    }

    //分页展示  跳转页面
    @RequestMapping("/fittings/{pageNum}")//findAll加第几页    pageNum当前页   PageSize页的大小
    public String fittingspage(@PathVariable("pageNum") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "10") Integer PageSize,
                               HttpSession session) {

        if(session.getAttribute("admin")!=null){
            PageSize = 12;
        }

        //取得 条件筛选 信息
        String fstyle = (String) session.getAttribute("fstyle");
        String ftype = (String) session.getAttribute("ftype");
        //如果是进入网站首页，没有选择 条件筛选 信息 ，则fstyle和ftype都为null

        System.out.println("fstyle:"+fstyle);
        System.out.println("ftype:"+ftype);

        try{
            PageInfo pageInfo;

            if(fstyle!=null && ftype!=null){//种类 且 风格 全不为空
                if("全部".equals(fstyle) && "全部".equals(ftype)){//全部 全部
                    pageInfo = fittingService.fingAll(pageNum,PageSize);
                }else if(!"全部".equals(fstyle) && !"全部".equals(ftype)){//都不为 全部
                    System.out.println("正常进入。。。。。。。。。。");
                    pageInfo = fittingService.fingByCondition(pageNum,PageSize,ftype,fstyle);
                }else if ("全部".equals(fstyle) && !"全部".equals(ftype)){//至少有一个条件  ftype
                    pageInfo = fittingService.fingByFtype(pageNum,PageSize,ftype);
                }else if("全部".equals(ftype) && !"全部".equals(fstyle)){//至少有一个条件  fstyle
                    pageInfo = fittingService.fingByFstyle(pageNum,PageSize,fstyle);
                }else {
                    pageInfo = fittingService.fingAll(pageNum,PageSize);
                }
            }else{//种类和风格 全为空
                pageInfo = fittingService.fingAll(pageNum,PageSize);
            }

            session.setAttribute("pageInfo",pageInfo);
        }catch (Exception e){
            System.out.println("userController中的fittingspage异常信息:");
            e.printStackTrace();
        }

        if(session.getAttribute("admin")!=null){
            return "/WEB-INF/jsp/adminmenu.jsp";//列表页面
        }else {
            return "/menu.jsp";//列表页面
        }
    }

    //储存条件筛选 信息     弃用
    @RequestMapping("/select")//findAll    pageNum当前页   PageSize页的大小
    public String select(HttpSession session,
                         String fstyle,String ftype) {

        System.out.println("fstyle:"+fstyle);
        System.out.println("ftype:"+ftype);

        session.setAttribute("fstyle",fstyle);
        session.setAttribute("ftype",ftype);

        return "/fitting/fittings";//列表页面
    }

    //储存条件筛选 信息
    @RequestMapping("/selects/{sname}")//findAll    pageNum当前页   PageSize页的大小
    public String selects(@PathVariable("sname")String sname, HttpSession session) {
        System.out.println("fstyle:"+sname);
        session.setAttribute("fstyle",sname);
        session.setAttribute("ftype","全部");
        return "/fitting/fittings";//列表页面
    }

    //储存条件筛选 信息
    @RequestMapping("/selectt/{tname}")//findAll    pageNum当前页   PageSize页的大小
    public String selectt(@PathVariable("tname")String tname, HttpSession session) {
        System.out.println("ftype:"+tname);
        session.setAttribute("fstyle","全部");
        session.setAttribute("ftype",tname);
        return "/fitting/fittings";//列表页面
    }


    //进入某个家居的详情界面
    @RequestMapping("/details/{fid}")
    public String details(@PathVariable("fid") String fid,
                          HttpServletRequest request,
                          HttpSession session){
        //通过fid查询家居详情
        FittingDetail fittingDetail = fittingService.queryDetailsByFid(fid);
        System.out.println(fittingDetail);
        session.setAttribute("f",fittingDetail);

        //通过fid查询此家居的评论信息
        List<Comment> list = commentService.findAllByFid(fid);
        //要放在if语句外面，因为即使没有评论，也要把session域中内容更新
        List<CommentVo> listVo = new ArrayList();
        if(list!=null){
            for(Comment c:list){//因为查询出来的list里的Comment的ctime类型均为Date类型，在网页展示不好。所以全部换为时间字符串可在网页展示
                CommentVo commentVo = new CommentVo();
                commentVo.setNickname(c.getNickname());
                commentVo.setContent(c.getContent());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                commentVo.setCtime(sdf.format(c.getCtime()));
                listVo.add(commentVo);
            }
        }
        session.setAttribute("comments",listVo);

        User u = (User) session.getAttribute("user");
        if(u!=null){
            String uid = u.getUid();
            List<Suit> list2 = suitService.QueryAllByUid(uid);
            request.getSession().setAttribute("suits",list2);//sid uid sname
        }

        //return "/user/QuerySuit";
        return "/intro.jsp";
    }





}
