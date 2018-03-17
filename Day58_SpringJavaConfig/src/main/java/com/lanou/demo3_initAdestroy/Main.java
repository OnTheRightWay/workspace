package com.lanou.demo3_initAdestroy;

import com.lanou.demo3_initAdestroy.config.ELConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig bean = context.getBean(ELConfig.class);
        bean.outputResource();
        context.close();
    }
}
