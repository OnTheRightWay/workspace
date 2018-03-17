package com.nys.controller;

import com.nys.domain.NysMessage;
import com.nys.domain.NysResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NysController {

    @MessageMapping("/welcome")//当浏览器向服务器发送请求时，通过@MessageMapping映射/welcome这个地址
    //类似于@RequestMapping
    @SendTo("/topic/getResponse")//当服务器有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public NysResponse say(NysMessage nysMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new NysResponse("Welcome,"+nysMessage.getName()+"!");
    }
}
