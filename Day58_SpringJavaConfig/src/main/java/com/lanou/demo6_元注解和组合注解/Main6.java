package com.lanou.demo6_元注解和组合注解;

import com.lanou.demo6_元注解和组合注解.config.MyConfig;
import com.lanou.demo6_元注解和组合注解.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.output();
        context.close();
    }
}
