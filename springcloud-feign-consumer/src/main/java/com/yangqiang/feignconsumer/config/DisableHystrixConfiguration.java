package com.yangqiang.feignconsumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: 杨强
 * @Date: 2019/7/8 23:08
 * @Version 1.0
 * @Discription 构建关闭Hystrix的配置类
 */
@Configuration
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
