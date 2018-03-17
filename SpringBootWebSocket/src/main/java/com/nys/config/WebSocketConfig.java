package com.nys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker//开启使用STOMP，用来传输基于代理的消息，此时控制器支持使用
//@messageMapping 就像使用@RequestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册STOMP 协议的节点（endpoint）并映射到指定的URL
        //注册一个STOMP的endpoint，并指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/endpointNiu").withSockJS();

    }


    public void configureMessageBroker(MessageBrokerRegistry registry){
        //广播式应配置一个/topic的消息代理
        registry.enableSimpleBroker("/topic");
    }
}
