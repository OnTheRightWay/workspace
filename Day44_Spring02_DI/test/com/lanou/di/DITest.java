package com.lanou.di;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

public class DITest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void person() throws Exception {
        Object per = context.getBean("per");
        System.out.println(per);
    }

    @Test
    public void person2() throws Exception {
        Object per = context.getBean("per");
        System.out.println(per);

    }

    @Test
    public void test() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("1.properties");
        String name = properties.getProperty("name");
        System.out.println(name);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
    }
}