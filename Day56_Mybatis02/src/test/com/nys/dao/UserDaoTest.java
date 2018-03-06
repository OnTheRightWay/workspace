package com.nys.dao;

import com.nys.dao.impl.UserDaoImpl;
import com.nys.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    @Test
    public void findById() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User byId = userDao.findById(3);
        System.out.println(byId);
    }
}