package com.lanou.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {
    @Autowired
    private UserService userService;


    public String userAction(){
        System.out.println(userService.getUser());
        return "success";
    }
}
