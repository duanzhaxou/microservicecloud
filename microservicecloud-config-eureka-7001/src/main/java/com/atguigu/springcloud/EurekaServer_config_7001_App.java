package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午4:10:34
 */
/*
 * eureka自我保护机制：某时刻 某一个服务 不可用 了，eureka 不会立刻 清理，依旧 会对该 微服务的信息 进行保存
 */
/**
 * 从 github 拉取配置 版的 eurka 7001
 * @author ASUS
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_config_7001_App {

	public static void main(String[] args) {
 		SpringApplication.run(EurekaServer_config_7001_App.class, args);
	}

}
