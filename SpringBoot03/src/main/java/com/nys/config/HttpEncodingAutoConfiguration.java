package com.nys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration//是一个配置类
//通过该注解开启属性注入，使用@Autowired注入
@EnableConfigurationProperties(HttpEncodingProperties.class)
//多条件注解：当CharacterEncodingFilter在类路径的条件下
@ConditionalOnClass(CharacterEncodingFilter.class)
//条件注解：当spring.http.encoding=enable情况下条件符合
//如果没有设置（mathIfMissing），则默认为true，条件也符合
@ConditionalOnProperty(prefix = "spring.http.encoding",value = "enable",matchIfMissing = true)
public class HttpEncodingAutoConfiguration {
    @Autowired
    private HttpEncodingProperties httpEncodingProperties;

    @Bean//使用java配置的方式，在当前这个配置类只中，创建一个bean
    //当容器中没有这个bean的时候，新建一个
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)
    public CharacterEncodingFilter characterEncodingFilter(){
        OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.httpEncodingProperties.getCharset().name());
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        return filter;
    }
}
