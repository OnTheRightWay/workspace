package com.lanou.demo6_元注解和组合注解.service;

import com.lanou.demo6_元注解和组合注解.anno.MyConfiguration;

@MyConfiguration
public class MyService {
    public void output(){
        System.out.println("组合注解@MyConfiguration好用了");
    }
}
