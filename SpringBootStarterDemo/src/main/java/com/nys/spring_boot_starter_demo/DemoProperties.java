package com.nys.spring_boot_starter_demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

//在配置文件中通过：demo.msg=xxx来配置msg
//若不配置，则默认为：我是DEMO
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    public static final String MSG = "我是DEMO";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
