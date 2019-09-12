package com.yangqiang.feignconsumer.controller;

import com.yangqiang.feignconsumer.client.HelloController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 杨强
 * @Date: 2019/7/7 22:12
 * @Version 1.0
 * @Discription
 */
@RestController
@Slf4j
public class FeignConsumerController {

    @Autowired
    private HelloController helloController;

    @RequestMapping("/feignConsumer")
    public  String  testHello(){
        System.err.println("开始调用");
        String str = helloController.sayHello();
        System.err.println(str);
        return "success";

    }
}
