package com.nys.crm.user.service;

import com.nys.crm.user.dao.impl.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public void find() {
        userDao.get();
    }
}
