package com.lanou.service;

import com.lanou.anno.Action;
import org.springframework.stereotype.Service;
//标识这是一个Service，也是Spring中的一个Bean
@Service
public class AopDemoService {
    @Action(name = "66666")
    public void showAop(){

    }
}
