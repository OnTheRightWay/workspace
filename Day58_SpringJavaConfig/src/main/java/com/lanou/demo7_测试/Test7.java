package com.lanou.demo7_测试;

import com.lanou.demo7_测试.config.TestConfig;
import com.lanou.demo7_测试.service.TargetService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//在Junit环境下提供Spring TestContext Framework的功能
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置ApplicationContext，classes参数用来加载配置类
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")//声明当前正在活动的profile(可以理解为环境)
public class Test7 {
    @Autowired//注入
    private TargetService targetService;

    @Test
    public void prodBeanShouldInject(){
        String expected = "for production profile";
        String actual = targetService.getContent();

        //判断二者是否相等
        Assert.assertEquals(expected,actual);
    }
}
