package com.lanou.demo3;

import com.lanou.demo3.config.InitDesConfig;
import com.lanou.demo3.service.BeanService;
import com.lanou.demo3.service.JSR250Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDesMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(InitDesConfig.class);
        JSR250Service jsr250Service = context.getBean(JSR250Service.class);
        BeanService beanService = context.getBean(BeanService.class);
        context.close();
    }
}
