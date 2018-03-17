package com.nys.spring_boot_starter_demo;

import org.springframework.stereotype.Service;

//当进行自动配置时，判断DemoService是否存在，若存在，则创建这个类的Bean
@Service
public class DemoService {
    private String msg;
    public String say(){
        return "hello:"+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
