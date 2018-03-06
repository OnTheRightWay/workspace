package com.lanou.study.web;

import com.lanou.study.domain.User;
import com.lanou.study.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends ActionSupport implements ModelDriven{
    private User user = new User();
    private int id;
    @Autowired
    private UserService userService;
    public String get(){
        User user = userService.get(id);
        if (user==null){
            return SUCCESS;
        }
        ServletActionContext.getRequest().setAttribute("user",user.toString());
        return SUCCESS;
    }
    public String add(){

        userService.add(user);
        return SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
