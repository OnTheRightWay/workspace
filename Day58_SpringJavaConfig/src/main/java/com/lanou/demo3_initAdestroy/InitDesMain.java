package com.lanou.demo3_initAdestroy;

import com.lanou.demo3_initAdestroy.config.InitDesConfig;
import com.lanou.demo3_initAdestroy.service.BeanService;
import com.lanou.demo3_initAdestroy.service.JSR250Service;
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
