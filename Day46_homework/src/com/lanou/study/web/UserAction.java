package com.lanou.study.web;

import com.lanou.study.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends ActionSupport{
    @Autowired
    private UserService userService;
    public String get(){
        userService.get();
        return SUCCESS;
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
