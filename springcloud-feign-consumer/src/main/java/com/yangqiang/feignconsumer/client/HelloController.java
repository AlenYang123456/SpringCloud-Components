package com.yangqiang.feignconsumer.client;

import com.yangqiang.feignconsumer.config.DisableHystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 杨强
 * @Date: 2019/7/7 22:09
 * @Version 1.0
 * @Discription
 */
@FeignClient(value = "HELLO-SERVICE"
        ,configuration = DisableHystrixConfiguration.class //细粒度的超时配置
        ,fallback = HelloControllerFallback.class)         //服务降级类
public interface HelloController {
        @RequestMapping("/hello")
        public String  sayHello();

}
