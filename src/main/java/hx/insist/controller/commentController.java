package hx.insist.controller;

import hx.insist.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class commentController {

    @Autowired
    private CommentService commentService;


}
