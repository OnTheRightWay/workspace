package com.ssm.user.controller;

import com.ssm.user.dao.UserMapper;
import com.ssm.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/tor")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user){
        userMapper.insertUser(user);
        return "redirect:/user/login";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}