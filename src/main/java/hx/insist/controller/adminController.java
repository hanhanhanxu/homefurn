package hx.insist.controller;

import com.github.pagehelper.PageInfo;
import hx.insist.Vo.OrderVo;
import hx.insist.pojo.Fitting;
import hx.insist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
        return "/fitting/fittings";
    }

    //点击主页  退出登录
    @RequestMapping("/Reception")
    public String Reception(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/fitting/index";
    }

    @RequestMapping("/addfitting")//跳到添加家居页面
    public String addfitting(HttpServletRequest request){
        //先去查找种类  和  风格
        List listType = typeService.findAllType();
        List listStyle = styleService.findAllStyle();

        //将type 和 style 存储到request中
        request.setAttribute("type",listType);
        request.setAttribute("style",listStyle);

        return "/WEB-INF/jsp/addfitting.jsp";
    }


    @RequestMapping("/addfittingImpl")//处理添加家居请求
    public String addfittingImpl(@RequestParam("preimg") MultipartFile preimg,
                                HttpServletRequest request,
                                Fitting fitting){

       /*先不做校验，因为跳转要跳好几次
       if(!fitting.Verification()){
            return "";
        }*/

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
            adminService.addFitting(fitting);
            System.out.println("此家居所有内容已保存完毕...");
            return "/admin/index";//去加载，然后返回admin页面
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg","添加家居时，储存家居图片发生异常！");
        return "/error.jsp";
    }


    @RequestMapping("/addtype")//去添加种类页面
    public String addtype(){
        return "/WEB-INF/jsp/addtype.jsp";
    }


    @RequestMapping("/addtypeImpl")//处理添加种类请求
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


    @RequestMapping("/addstyle")//去添加风格页面
    public String addstyle(){
        return "/WEB-INF/jsp/addstyle.jsp";
    }


    @RequestMapping("/addstyleImpl")//处理添加风格请求
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
    @ResponseBody
    @RequestMapping("/ordermanage")
    public String ordermanage(HttpServletRequest request){
        /**1、从订单表order 中查询所有订单
         * 2、拿着每一个oid查询每个订单对应的所有订单详情
         * 3、把这些信息转换为OrderVo
         */
        System.out.println("ordermanage..............");

        PageInfo<OrderVo> pageInfo = orderService.fingAll(0, 10);
        request.getSession().setAttribute("pageInfoOrderVoList",pageInfo);//只能储存到session中
        //pageInfoOrderVoList.list是里面的一个个元素 订单OrderVo
        //pageInfoOrderVoList.list.orderitems是OrderVo中储存的一个个订单详情orderitem
        /*List<OrderVo> list = pageInfo.getList();
        for(OrderVo o:list){
            for(Orderitem oi:o.getOrderitems()){
                System.out.println(oi);
            }
        }*/
        return "success";
    }


}