package com.lanou.study.service;

import com.lanou.study.dao.UserDao;
import com.lanou.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(int id){
        return userDao.get(id);
    }

    public void add(User user) {
        userDao.add(user);
    }
}
