package com.lanou.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lanou")
@EnableAspectJAutoProxy//开启对AspectJ的支持
public class AopConfig {

}
