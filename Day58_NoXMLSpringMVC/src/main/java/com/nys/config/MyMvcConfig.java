package com.nys.config;

import com.nys.interceptor.ShowIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.nys")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    /**
     * @return  是SpringMVC视图渲染的核心机制
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        //jsp页面前缀
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        //后缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    //访问程序的静态文件（js,css,图片）等需要使MVC配置类
    //继承WebMvcConfigurerAdapter
    //并进行如下配置


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourcesHandler指的是对外暴露的访问路径
        //addResourceLocation指的是文件放置的目录
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
    }

    @Bean//这是拦截器
    public ShowIntercept showIntercept(){
        return new ShowIntercept();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(showIntercept());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //路径为/index的请求，显示名称为index的视图
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //不做匹配，则不会忽略，路径参数.后面的内容
        configurer.setUseSuffixPatternMatch(false);
    }
}
