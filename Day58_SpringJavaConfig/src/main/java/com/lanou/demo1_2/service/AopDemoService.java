package com.lanou.demo1_2.service;

import com.lanou.demo1_2.anno.Action;
import org.springframework.stereotype.Service;
//标识这是一个Service，也是Spring中的一个Bean
@Service
public class AopDemoService {
    @Action(name = "66666")
    public void showAop(){

    }
}
