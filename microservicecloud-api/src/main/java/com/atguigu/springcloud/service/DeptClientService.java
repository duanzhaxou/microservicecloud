package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atguigu.springcloud.entities.Dept;

/**
 * @ClassName:
 * @Description:一个接口，一个注解，指定一个要调用的微服务名称，并且feign 集成了ribbon ，自带 轮询负载均衡，无需额外的配置
 * @author DuanZhaoXu
 * @data 2018年9月30日下午2:56:33
 */

@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

	@PostMapping(value="/dept/add")
	public  boolean  add(@RequestBody Dept dept) ;
	
	@GetMapping("/dept/get/{id}")
	public  Dept get(@PathVariable("id") Long id) ;
	
	@GetMapping("/dept/list")
	public List<Dept> list();
	
	
}
