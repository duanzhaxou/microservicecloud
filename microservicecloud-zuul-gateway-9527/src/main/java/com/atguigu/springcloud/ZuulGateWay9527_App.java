package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * zuul 网关 配置
 * 1、引入 zuul 和  eureka 客户端的依赖，然后 配置eureka，让自己注册到 rueaka 上面去，
 * 2、在 启动类上面 添加 @EnableZuulProxy 注解 即可。
 * 
 * 就可以使用  http//localhost:9527/{微服务名称}/dept/get/2 请求 服务接口。
 * @author ASUS
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateWay9527_App {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateWay9527_App.class, args);
	}
}
