package com.lanou.study.dao;

import com.lanou.study.domain.User;


public class UserDao {
    private User user;
    public void addUser(){
        System.out.println("-----添加了一个User-----"+user.getName());
    }

    public void setUser(User user) {
        this.user = user;
    }
}
