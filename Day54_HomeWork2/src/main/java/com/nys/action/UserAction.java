package com.nys.action;

import com.nys.domain.User;
import com.nys.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware{
    @Autowired
    private UserService userService;
    private User user = new User();
    private HttpServletRequest request;

    public String register(){
        String status = userService.register(user);
        if (!status.equals("success")){
            request.setAttribute("register",user);
            return "register";
        }
        return "login";
    }
    public String login(){
        User login = userService.login(user.getUsername(),user.getPassword());
        if (login==null){
            request.setAttribute("login",user);
            return "login";
        }
        return "index";
    }

    public User getModel() {
        return user;
    }

    public void setServletRequest(javax.servlet.http.HttpServletRequest httpServletRequest) {
        request=httpServletRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
