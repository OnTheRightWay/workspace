package com.lanou.demo1_2;

import com.lanou.demo1_2.config.SpringConfig;
import com.lanou.demo1_2.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloService helloService =
                context.getBean(HelloService.class);
        helloService.sayHello();
        context.close();
    }
}
