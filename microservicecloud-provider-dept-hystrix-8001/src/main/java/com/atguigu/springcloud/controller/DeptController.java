package com.atguigu.springcloud.controller;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午2:33:02
 */


@RestController
public class DeptController {
	
	@Autowired
	private DiscoveryClient  discoveryClient;

	@Autowired
	private DeptService service;
	
	@PostMapping(value="/dept/add")
	public  boolean  add(@RequestBody Dept dept) {
	return service.add(dept);	
	}
	
	
	/**
	 * 服务端增加 @HystrixCommand 实现 服务 熔断，但是这样每次写一个接口，都要写 一个 相对应的
	 * 熔断回调的方法，造成的服务膨胀和 高耦合度，因此需要将 改成熔断回调，通过 实现FallBackFactory接口 实现在 客户端
	 * @param id
	 * @return
	 */
	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod="getWithHystrix")
	public  Dept get(@PathVariable("id") Long id) {
		   Dept dept =  service.get(id);
		   if(dept==null ) {
			   throw new RuntimeException("没有该部门");
		   }
		   return dept;
		 }
	
	public  Dept  getWithHystrix(@PathVariable("id") Long id) {
		return new Dept("没有编号为"+id+"的 部门-----@@HystrixCommand");
	}
	
	@GetMapping("/dept/list")
	public List<Dept> list(){
	  System.out.println("负载均衡  8001");
      return service.list();
	}
	
	
	@GetMapping("/dept/discovery")
	public  Object  getService() {
	List<String> services =  discoveryClient.getServices();
	System.out.println(services);
	for(String id : services) {
//		        [microservicecloud-dept]
//				192.168.42.193|8001|MICROSERVICECLOUD-DEPT|http://192.168.42.193:8001
//				------------------
//				management.port:8001
//				jmx.port:49269
		List<ServiceInstance>  instances = 	 discoveryClient.getInstances(id);
		for(ServiceInstance serviceInstance : instances) {
			 System.out.println(serviceInstance.getHost()+"|"+serviceInstance.getPort()+"|"+serviceInstance.getServiceId()+"|"+serviceInstance.getUri());
			 System.out.println("------------------");
			 for (Entry<String, String> entry :serviceInstance.getMetadata().entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
	return  discoveryClient;
}
	
}
