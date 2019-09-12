package com.yangqiang.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker //开启熔断
@EnableEurekaClient   //声明这是一个eureka客户端
public class SpringcloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getInstance(){
		return new RestTemplate();
	}

}
