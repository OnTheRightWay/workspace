package com.nys.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/store_article").setViewName("/store_article");
        registry.addViewController("/ddpj").setViewName("/ddpj");
        registry.addViewController("/dfh").setViewName("/dfh");
        registry.addViewController("/dpj").setViewName("/dpj");
        registry.addViewController("/dsh").setViewName("/dsh");
        registry.addViewController("/dzwh").setViewName("/dzwh");
        registry.addViewController("/empty").setViewName("/empty");
        registry.addViewController("/fenlei").setViewName("/fenlei");
        registry.addViewController("/fw").setViewName("/fw");
        registry.addViewController("/grzx").setViewName("/grzx");
        registry.addViewController("/gwc").setViewName("/gwc");
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/toLogin").setViewName("/login");
        registry.addViewController("/lyb").setViewName("/lyb");
        registry.addViewController("/news").setViewName("/news");
        registry.addViewController("/pro_detail").setViewName("/pro_detail");
        registry.addViewController("/pro_detailc_").setViewName("/pro_detailc_");
        registry.addViewController("/pro_list").setViewName("/pro_list");
        registry.addViewController("/qhcs").setViewName("/qhcs");
        registry.addViewController("/regest").setViewName("/regest");
        registry.addViewController("/regest1").setViewName("/regest1");
        registry.addViewController("/sp").setViewName("/sp");
        registry.addViewController("/sqkd").setViewName("/sp");
        registry.addViewController("/sz").setViewName("/sz");
        registry.addViewController("/wddd").setViewName("/wddd");
        registry.addViewController("/wdsc").setViewName("/wdsc");
        registry.addViewController("/xgmm").setViewName("/xgmm");
        registry.addViewController("/xzdp").setViewName("/xzdp");
        registry.addViewController("/xzdp1").setViewName("/xzdp1");
        registry.addViewController("/xzdpx").setViewName("/xzdpx");
        registry.addViewController("/xzdz").setViewName("/xzdz");
        registry.addViewController("/xzsq").setViewName("/xzsq");
        registry.addViewController("/yqx").setViewName("/yqx");
        registry.addViewController("/ywc").setViewName("/ywc");
    }
}
