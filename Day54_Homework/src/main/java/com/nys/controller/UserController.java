package com.nys.controller;

import com.nys.domain.User;
import com.nys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService = new UserService();
    @RequestMapping("/register")
    public String register(User user, Model model){
        String status = userService.insert(user);
        if (!status.equals("success")){
            model.addAttribute("register",user);
            return "register";
        }
        return "login";
    }
    @RequestMapping("/login")
    public String login(User user,Model model){
        User login = userService.login(user.getUsername(),user.getPassword());
        if (login==null){
            model.addAttribute("login",user);
            return "login";
        }
        return "homePage";
    }
}
