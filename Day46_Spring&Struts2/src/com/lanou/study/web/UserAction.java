package com.lanou.study.web;

import com.lanou.study.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    private UserService userService;
    public String register(){
        userService.register();
        return SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
