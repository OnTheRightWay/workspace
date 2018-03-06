package com.lanou.study.service;

import com.lanou.study.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(){
        userDao.addUser();
        System.out.println("-----service----");
    }
}
