package com.lanou.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDao {
    @Autowired
    private User user;
    public User createUser(){
        return user;
    }
}
