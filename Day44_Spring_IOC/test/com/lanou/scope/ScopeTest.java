package com.lanou.scope;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ScopeTest {
    private ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(
                "spring-config.xml"
        );
    }

    @Test
    public void lazy() throws Exception {
        //懒加载，只有在获得对象时才会执行构造方法
        context.getBean("car");
        context.getBean("car");
        context.getBean("car");
    }

    @Test
    public void prototype() throws Exception {
        context.getBean("stu,yyy");
        context.getBean("student");
        context.getBean("student2");
        context.getBean("xxx");


    }
}