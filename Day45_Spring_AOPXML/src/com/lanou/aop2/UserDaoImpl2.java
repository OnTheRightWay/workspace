package com.lanou.aop2;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("userDao2")
public class UserDaoImpl2 implements UserDao2 {

    @Override
    public void add() {
        System.out.println("------------add--------------");
    }

    @Override
    public void delete() {
        System.out.println("------------delete-------------");
    }
}
