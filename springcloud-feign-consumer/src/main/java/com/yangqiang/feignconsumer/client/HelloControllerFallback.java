package com.yangqiang.feignconsumer.client;

import org.springframework.stereotype.Component;

/**
 * @Author: 杨强
 * @Date: 2019/7/8 23:22
 * @Version 1.0
 * @Discription 服务降级类
 */
@Component //实现FeignClient声明的接口,重写其方法,指定服务降级的逻辑即可
public class HelloControllerFallback implements HelloController{
    @Override
    public String sayHello() {
        //服务降级的逻辑
        return "error";
    }
}
