package com.yangqiang.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	/**
	 *需要将Filter加入到Spring容器的管理中?为什么?
	 *
	 * 个人理解:因为AccessFilter这个过滤器是netfliex.zuul组件中的APi,需要被Spring容器管理
	 * 因此要加入到Spring容器中
	 *
	 *
	 */
}
