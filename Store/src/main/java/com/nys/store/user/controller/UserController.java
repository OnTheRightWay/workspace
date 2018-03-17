package com.nys.store.user.controller;

import com.nys.store.user.domain.User;
import com.nys.store.user.domain.UserWrap;
import com.nys.store.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/login")
    public UserWrap login(User user){
        User login = userService.selectByLogin(user);
        return new UserWrap(200,"success",login);
    }

    @RequestMapping("/selectByPhone")
    public UserWrap selectByPhone(String phone){
        User byPhone = userService.selectByPhone(phone);
        return new UserWrap(200,"success",byPhone);
    }

    @RequestMapping("/selectByUsername")
    public UserWrap selectByUsername(String user_name){
        User byUsername = userService.selectByUsername(user_name);
        return new UserWrap(200,"success",byUsername);
    }

    @RequestMapping("/insertUser")
    public String insertUser(User user){
        userService.insertUser(user);
        return "success";
    }

}
