package com.lanou.aop;

import com.lanou.aop2.UserDao2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void aop() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml"
        );
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.add();
        userDao.delete();
    }

    @Test
    public void aop2() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml"
        );
        UserDao2 userDao2 = (UserDao2) context.getBean("userDao2");
        userDao2.add();
        userDao2.delete();

    }
}