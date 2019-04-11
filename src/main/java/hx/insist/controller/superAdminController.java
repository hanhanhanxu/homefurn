package hx.insist.controller;

import hx.insist.service.AdminService;
import hx.insist.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/superadmin")
public class superAdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/logoff")
    public String logoff(HttpSession session){
        session.removeAttribute("superadmin");
        return "redirect:/index.jsp";
    }

    //会不会存在多线程问题？，当存在多个人登录root用户同时生成账号时，就会出现
    @RequestMapping("/createAdmin")
    public String createAdmin(Model model){
        String ausername = WebUtil.randomNum(8);
        String apassword = WebUtil.randomNum(8);
        System.out.println("新生成的子管理员账户:"+ausername+":"+apassword);

        adminService.generateAdmin(ausername,apassword);

        model.addAttribute("ausername",ausername);
        model.addAttribute("apassword",apassword);
        return "/WEB-INF/jsp/superadmin.jsp";
    }
}
