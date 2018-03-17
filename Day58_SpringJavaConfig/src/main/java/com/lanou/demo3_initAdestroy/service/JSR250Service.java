package com.lanou.demo3_initAdestroy.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250Service {
    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }
    public JSR250Service(){
        System.out.println("构造方法：JSR250Service");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}
