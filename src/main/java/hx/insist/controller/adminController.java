package hx.insist.controller;

import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderinfoVo;
import hx.insist.pojo.Fitting;
import hx.insist.pojo.Lunbo;
import hx.insist.pojo.Message;
import hx.insist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private FittingService fittingService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private StyleService styleService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private LunboService lunboService;
    @Autowired
    private OrderinfoService orderinfoService;

    //      /必须带上  访问的时候也要带上
    /*@RequestMapping("/")//这样也可以？ 直接访问 http://localhost:8080/homefurn/admin/
    public String admin(){
        return "/WEB-INF/jsp/admin.jsp";
    }*/

    //加载管理员首页
    @RequestMapping("/index")//加载 种类、风格 信息
    public String index(HttpSession session){
        System.out.println("/admin/index：加载种类、风格信息");
        List listType = typeService.findAllType();
        List listStyle = styleService.findAllStyle();
        session.setAttribute("type",listType);
        session.setAttribute("style",listStyle);

        //储存家居销量展示
        List<Fitting> list = fittingService.selectForRank();
        session.setAttribute("FittingRank",list);

        //储存订单信息
        //所有
        PageInfo<OrderinfoVo> pageInfo = orderinfoService.getAll(0,10);
        //PageInfo<OrderVo> pageInfo = orderService.fingAll(0, 10);
        session.setAttribute("pageInfoOrderinfoVoList",pageInfo);
        //待发货
        PageInfo<OrderinfoVo> pageInfo2 = orderinfoService.getAllByOfstate(0,10,"待发货");
        session.setAttribute("pageInfoOrderinfoVoList2",pageInfo2);
        //已发货
        PageInfo<OrderinfoVo> pageInfo3 = orderinfoService.getAllByOfstate(0,10,"已发货");
        session.setAttribute("pageInfoOrderinfoVoList3",pageInfo3);
        //已收货
        PageInfo<OrderinfoVo> pageInfo4 = orderinfoService.getAllByOfstate(0,10,"已收货");
        session.setAttribute("pageInfoOrderinfoVoList4",pageInfo4);

        //储存留言信息
        PageInfo<Message> pageInfo1 = messageService.select(0,10);
        session.setAttribute("Messages",pageInfo1);

        //储存轮播图信息
        List<Lunbo> listlunbo = lunboService.selectAll();
        session.setAttribute("lunbo",listlunbo);

        return "/fitting/fittings";
    }

    //点击主页  退出登录
    @RequestMapping("/Reception")
    public String Reception(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/fitting/index";
    }


    @RequestMapping("/deletefitting/{fid}")
    public String deletefitting(@PathVariable String fid){
        fittingService.xiajiaFitting(fid);
        return "/admin/index";
    }

    @RequestMapping("/addfittingImpl")//处理添加家居请求
    public String addfittingImpl(@RequestParam("preimg") MultipartFile preimg,
                                HttpServletRequest request,
                                Fitting fitting,int fsnum){

       /*先不做校验，因为跳转要跳好几次
       if(!fitting.Verification()){
            return "";
        }*/

        System.out.println(fsnum);
        //检验上传的图片是否为空
        if(preimg.isEmpty()){
            request.setAttribute("msg","图片为空...");
            return "/error.jsp";
        }

        //得到图片的新的储存路径，把这个路径放在数据库中
        //1. 获取图片完整名称
        String fileStr = preimg.getOriginalFilename();
        System.out.println("图片原始名称:"+fileStr);
        //2. 使用随机生成的字符串+源图片扩展名组成新的图片名称,防止图片重名
        String newfileName = UUID.randomUUID().toString() + fileStr.substring(fileStr.lastIndexOf("."));
        System.out.println("图片新名称:"+newfileName);

        String filepath = request.getServletContext().getRealPath("/coverimg");//设置保存的路径
        System.out.println("图片的保存路径为:"+filepath);

        //至关重要，必须有。 确认保存路径存在
        File file = new File(filepath);
        if (!file.exists()) {
            file.mkdirs();
        }

        String savepath = filepath+"\\"+newfileName;
        System.out.println("图片储存完整路径:"+savepath);

        //添加保存路径
        fitting.setFimg(newfileName);

        try {
            //将图片保存到服务器端Fdecoration/coverimg文件夹下
            preimg.transferTo(new File(savepath));//会抛出异常
            System.out.println("图片保存成功...");

            System.out.println(fitting);
            //将数据保存到数据库中
            adminService.addFitting(fitting,fsnum);
            System.out.println("此家居所有内容已保存完毕...");
            return "/admin/index";//去加载，然后返回admin页面
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg","添加家居时，储存家居图片发生异常！");
        return "/error.jsp";
    }



    /*@RequestMapping("/lookfitting")//查找家居
    public String lookfitting(String q,HttpSession session){
        List<Fitting> list = fittingService.findByFname(q);
        if(list!=null){
            session.setAttribute("resjiaju",list);
        }
        return "/WEB-INF/jsp/adminmenu.jsp";
    }*/

    @ResponseBody
    @RequestMapping("/lookfitting")//查找家居
    public Map<String,Object> lookfitting(String q,HttpSession session){
        List<Fitting> list = fittingService.findByFname(q);
        Map<String,Object> map = new HashMap<>();
        if(list!=null){
            session.setAttribute("resjiaju",list);
            map.put("resCode",200);
            map.put("lookjiaju_res",list);
            return map;
        }else {
            map.put("resCode",0);
            return map;
        }
    }


    @RequestMapping("/addtypeImpl")//添加种类请求
    public String addtypeImpl(String typeName, HttpServletRequest request){
        //新增家居种类，传入家居种类名字，先查找，如果有重名返回1，没有返回0
        if(typeName.length()!=0){
            int n = adminService.addType(typeName);
            if(n==0){
                request.setAttribute("msg","添加成功!");
            }else{
                request.setAttribute("msg","添加失败，已有重名种类!");
            }
        }else{
            request.setAttribute("msg","添加失败，名称不能为空！");
        }

        return "/admin/index";
    }

    @RequestMapping("/deletetype/{tid}")//删除种类请求
    public String deletetype(@PathVariable String tid){
        typeService.delTypeByTid(tid);
        return "/admin/index";
    }


    @RequestMapping("/addstyleImpl")//添加风格请求
    public String addstyleImpl(String styleName,HttpServletRequest request){
        //新增家居种类，传入家居种类名字，先查找，如果有重名返回1，没有返回0
        if(styleName.length()!=0){
            int n = adminService.addStyle(styleName);
            if(n==0){
                request.setAttribute("msg","添加成功!");
            }else{
                request.setAttribute("msg","添加失败，已有重名风格!");
            }
        }else{
            request.setAttribute("msg","添加失败，名称不能为空！");
        }

        return "/admin/index";
    }

    @RequestMapping("/deletestyle/{sid}")//删除风格请求
    public String deletestyle(@PathVariable String sid){
        styleService.delStyleBySid(sid);
        return "/admin/index";
    }

    //销量排行
    @ResponseBody
    @RequestMapping("/fittingrank")
    public String fittingrank(HttpServletRequest request){
        System.out.println("fittingrank..............");

        List<Fitting> list = fittingService.selectForRank();
        request.getSession().setAttribute("FittingRank",list);
        return "success";
        //return "/WEB-INF/jsp/admin.jsp";
    }

    //订单管理
    //订单发货
    @RequestMapping("/order")
    public String order(String ofid){
        orderinfoService.orderByOfid(ofid);
        return "/admin/index";
    }

    //轮播图管理
    @ResponseBody
    @RequestMapping("/lunbo/add")
    public Map<String,Object> addlunbo(@RequestParam("file") MultipartFile file, HttpServletRequest request
                                        ,String num) {
        Assert.notNull(file, "上传文件不能为空");
        String filepath = request.getServletContext().getRealPath("/lunbotu");
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        //确保路径存在
        File file2 = new File(filepath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String savepath = filepath+"\\"+filename;
        //System.out.println("轮播图保存路径:"+savepath);
        System.out.println("num:"+num);
        Map map = new HashMap<String,Object>();
        try {
            //保存文件到服务器
            file.transferTo(new File(savepath));
            //保存到数据库
            Lunbo lunbo = new Lunbo();
            lunbo.setLpic(filename);
            lunbo.setLnum(Integer.valueOf(num));
            lunboService.add(lunbo);
            //返回json
            map.put("msg","ok");
            map.put("code",200);
            /*map.put("data",new HashMap<String,Object>(){
                {
                    put("src",savepath);
                }
            });*/
            //json.put("src",savepath);
            //json.put("result", imageUtil.getImageBinary(savepath));   好像不用这个前台也能展示预览图片
        } catch (Exception e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping("/lunbo/del/{lid}")
    public String dellunbo(@PathVariable("lid")String lid, HttpServletRequest request){
        String lpic = lunboService.selectHouzhui(lid);
        //删记录
        lunboService.del(lid);
        String filepath = request.getSession().getServletContext().getRealPath("/lunbotu") + "\\" + lpic;
        System.out.println(filepath);
        File file = new File(filepath);
        if (file.exists())
            //删文件
            file.delete();
        return "/admin/index";
    }

}