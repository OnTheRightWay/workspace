package com.lanou.demo4_aware;

import com.lanou.demo4_aware.config.AwareConfig;
import com.lanou.demo4_aware.service.AwareService;
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
