package hx.insist.controller;

import hx.insist.Vo.Account;
import hx.insist.pojo.Admin;
import hx.insist.pojo.Suit;
import hx.insist.pojo.Superadmin;
import hx.insist.pojo.User;
import hx.insist.service.AdminService;
import hx.insist.service.SuitService;
import hx.insist.service.SuperAdminService;
import hx.insist.service.UserService;
import hx.insist.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录相关controller
 */
@Controller
public class LoginRegistController {

    @Autowired
    private SuperAdminService superAdminService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private SuitService suitService;

    /*@RequestMapping("/logoff")
    public String logoff(String uid){

        return "";
    }*/


    //访问地址是:/homefurn/login
    @RequestMapping("/login")
    public String login(Account account, Model model,HttpSession session){
        //表单校验
        if(!account.Verification()){
            return "/menu.jsp";
        }
        //输出记录一下
        System.out.println(account.getUsername()+":"+account.getPassword());
        /**
         * 从数据库中对比账号密码
         * 1、比较看是不是root用户
         * 2、比较看是不是子管理员
         * 3、比较看是不是用户
         */
        Superadmin superadmin = superAdminService.login(account.getUsername(),WebUtil.md5(account.getPassword()));
        if(superadmin==null){
                Admin admin = adminService.login(account.getUsername(),WebUtil.md5(account.getPassword()));
                if(admin==null){
                    User user = userService.login(account.getUsername(),WebUtil.md5(account.getPassword()));
                    if(user==null){
                        model.addAttribute("msg","账号或密码错误");
                        return "/login.jsp";
                    }else{
                        //用户界面-----系统主界面，浏览家居
                        session.setAttribute("user",user);
                        return "/menu.jsp";
                    }
                }else{
                    //子管界面
                    session.setAttribute("admin",admin);
                    return "/admin/index";
                    //return "/WEB-INF/jsp/admin.jsp";
                }
        }else{
            //超管界面
            session.setAttribute("superadmin",superadmin);
            return "/WEB-INF/jsp/superadmin.jsp";
        }
    }



    @RequestMapping("/regist")
    public String regist(User user, Model model, HttpSession session, HttpServletRequest request){
        System.out.println(user.toString());

        //取得正确的验证码
        String checkcode2 = (String) session.getAttribute("checkcode2");
        request.getServletContext().removeAttribute("checkcode2");//清理空间.

        //表单校验
        if(!user.Verification(checkcode2)){
            System.out.println(user.getErrors().toString());
            model.addAttribute("user",user);
            return "/regist.jsp";
        }

        //从数据库中查询看有没有和admin  user 重的用户名
        if(adminService.countAdminByUsername(user.getUsername())>0 || userService.countUserByUsername(user.getUsername())>0){
            model.addAttribute("msg","已存在此用户名！");
            return "/regist.jsp";
        }

        //可以注册
        userService.regist(user);
        session.setAttribute("user",user);

        //默认为用户创建一个装饰
        Suit suit = new Suit();
        suit.setUid(user.getUid());
        suit.setSname("我的装饰一");
        suitService.addSuit(suit);
        return "/index.jsp";
    }
}