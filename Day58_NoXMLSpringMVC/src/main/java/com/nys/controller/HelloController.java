package com.nys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    //简单的页面跳转，可以直接在配置中设置
    //重写addViewController
//    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

    /**
     * 在springMVC中，路径参数如果带.,那么.后面的值将被忽略
     * 若想不忽略.后面的值，可以在配置类中重写configurePathMatch方法
     * @RequestMapping("/pathParam/{str}") 中的str就对应方法中的str参数
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value = ("/pathParam/{str}"),produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String pathParam(@PathVariable String str, HttpServletRequest request){
        return "url:"+request.getRequestURL()+" 参数值为："+str;
    }
}
