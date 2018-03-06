package com.nys.crm.user.web;

import com.nys.crm.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends ActionSupport{
    @Autowired
    private UserService userService;
    public String find(){
        userService.find();
        return SUCCESS;
    }
}
