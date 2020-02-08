package com.yangqiang.helloservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Gabriel
 * @date: 2020/2/9 1:08
 * @description 拦截器注册
 */
@Configuration
@Order
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private URIInterceptor uriInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(uriInterceptor).addPathPatterns("/**");
    }
}
