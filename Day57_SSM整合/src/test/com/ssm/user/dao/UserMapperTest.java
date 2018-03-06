package com.ssm.user.dao;

import com.ssm.user.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {
    private ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void findUserById() throws Exception {
        UserMapper userMapper = context.getBean(UserMapper.class);
        User userById = userMapper.findUserById(9);
        System.out.println(userById);
    }
}