package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午2:41:55
 */
@SpringBootApplication
@EnableEurekaClient    // eureka  客户端
@EnableDiscoveryClient   //服务 发现
public class DeptProviderConfig8001_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptProviderConfig8001_App.class, args);
	}
	
}
