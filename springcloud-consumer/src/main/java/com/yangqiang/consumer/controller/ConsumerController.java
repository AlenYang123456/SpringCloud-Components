package com.yangqiang.consumer.controller;

import com.netflix.discovery.converters.Auto;
import com.yangqiang.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 杨强
 * @Date: 2019/6/30 13:20
 * @Version 1.0
 * @Discription
 */
@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer")
    public  String  consumer(){
        String info = consumerService.sayHello();
        log.info("返回信息 : {}" ,info);
        return " consumer ,,success";
    }
}
