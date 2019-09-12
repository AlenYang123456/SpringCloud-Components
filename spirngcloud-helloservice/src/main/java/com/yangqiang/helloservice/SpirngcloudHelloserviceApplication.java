package com.yangqiang.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpirngcloudHelloserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpirngcloudHelloserviceApplication.class, args);
	}



}
