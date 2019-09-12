package com.yangqiang.helloservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author: 杨强
 * @Date: 2019/6/30 13:19
 * @Version 1.0
 * @Discription
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String  sayHello() throws InterruptedException {
        //设置超时时间 模拟网络延迟 来验证熔断机制,熔断默认时间是2000s
        Thread.sleep(new Random().nextInt(3000));
        return "hello";
    }
}
