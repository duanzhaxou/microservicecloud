package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午3:36:40
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptCustomer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptCustomer80_App.class, args);
	}
}
