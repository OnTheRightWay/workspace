package com.nys.store.user.service.impl;

import com.nys.store.user.domain.User;
import com.nys.store.user.mapper.UserMapper;
import com.nys.store.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByLogin(User user) {
        return userMapper.selectUserByLogin(user);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectUserByPhone(phone);
    }

    @Override
    public User selectByUsername(String user_name) {
        return userMapper.selectUserByUsername(user_name);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
