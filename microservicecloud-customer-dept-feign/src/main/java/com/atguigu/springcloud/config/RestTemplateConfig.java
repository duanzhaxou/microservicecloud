package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午3:26:06
 */

@Configuration
public class RestTemplateConfig {

	
	@Bean
	@LoadBalanced     // ribbon  是基于 ribbon 实现 的  一套客户端，负载均衡的工具，只需要在restTemplate 这里 增加一个 @LoadBalanced注解即可
	public  RestTemplate  restTemplate() {
		return new RestTemplate();
	}
	
	//设置 负载均衡算法 为 随机 算法，默认是 轮询算法
	@Bean
	public  IRule  iRule() {
		//return new RetryRule(); 先 轮询，如果其中 一个挂掉了，就不再访问挂掉的服务，只轮询其他正常服务
		return new RandomRule();
	}
}
