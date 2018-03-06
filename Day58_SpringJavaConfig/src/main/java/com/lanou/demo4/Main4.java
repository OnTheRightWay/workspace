package com.lanou.demo4;

import com.lanou.demo4.config.AwareConfig;
import com.lanou.demo4.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AwareConfig.class);
        context.refresh();
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResource();
        context.close();
    }
}
