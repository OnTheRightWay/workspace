package com.nys.service;

import com.nys.dao.UserDao;
import com.nys.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public String register(User user){
        User byUsername = userDao.findByUsername(user.getUsername());
        if (byUsername!=null){
            return "用户名已存在";
        }
        userDao.insert(user);
        return "success";
    }
    public User login(String username,String password){
        User user = userDao.findByUsername(username);
        if (user==null){
            return null;
        }
        if (!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }
}
