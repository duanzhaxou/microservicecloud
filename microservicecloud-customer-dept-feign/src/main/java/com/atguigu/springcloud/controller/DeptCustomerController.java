package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午3:27:57
 */
@RestController
@RequestMapping("/customer")
public class DeptCustomerController {

	
	
	
	//private String REST_URL_PREFIX = "http://localhost:8001";
	//整合 spring cloud ribbon 之后我们不需要再写死成localhost 加端口的形式，
	//直接用 服务 名称就可以实现 rest 服务调用 
	//private String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	@Autowired
	private DeptClientService  deptClientService;
	@GetMapping("/dept/add")
	public boolean addDept( Dept dept) {
		//return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
	   return deptClientService.add(dept);
	}

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
	//	return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	 return deptClientService.get(id);
	}

	//@SuppressWarnings("unchecked")
	@GetMapping("/dept/list")
	public List<Dept> list() {
		//return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	 System.out.println("feignClient 调用接口");
		return deptClientService.list();
	}

}
