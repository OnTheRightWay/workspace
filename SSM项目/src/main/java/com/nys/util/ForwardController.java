package com.nys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForwardController {
    @Autowired
    HttpServletRequest request;
    @RequestMapping("/goto")
    public String forward(String name){
        return name;
    }

    @RequestMapping("/quit")
    public String quit(){
        request.getSession().removeAttribute("admin");
        return "login";
    }
}
