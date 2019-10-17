package hx.insist.controller;

import hx.insist.pojo.Message;
import hx.insist.pojo.User;
import hx.insist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class messageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/add")
    public String addmessage(String textmessage,
                             HttpSession session){
        User u = (User) session.getAttribute("user");
        Message message = new Message();
        message.setMessage(textmessage);
        message.setUid(u.getUid());
        message.setNickname(u.getNickname());
        messageService.insert(message);
        return "/menu.jsp";
    }
}
