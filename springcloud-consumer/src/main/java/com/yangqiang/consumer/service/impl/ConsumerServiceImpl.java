package com.yangqiang.consumer.service.impl;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangqiang.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 杨强
 * @Date: 2019/7/4 14:30
 * @Version 1.0
 * @Discription
 */
@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public String sayHello(){
        long start = System.currentTimeMillis();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        long end = System.currentTimeMillis();
        System.err.println("耗时为......"+(end-start)/1000);
        String body = responseEntity.getBody();
        return "success";
    }

    /**
     * 熔断回调的方法
     * @return
     */
    public String hello(){
        System.err.println("熔断生效,调用回调方法....");
        return "error";
    }
}
