package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午3:36:40
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344 {

	/**
	 * config  server  访问远端 github 问价， http://localhost:3344/application-dev.yml
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Config_3344.class, args);
	}
}
