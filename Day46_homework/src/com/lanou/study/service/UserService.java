package com.lanou.study.service;

import com.lanou.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public void get() {
        userDao.get();
    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
}
