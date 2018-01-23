package com.lanou.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @Qualifier("userDao1")
    private UserDao userDao;

    public User getUser(){
        return userDao.createUser();
    }
}
