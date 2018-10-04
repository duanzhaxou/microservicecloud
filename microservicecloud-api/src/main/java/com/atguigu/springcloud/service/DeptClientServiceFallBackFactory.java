package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 1,实现 FallBackFactory,
 * 2,增加  Component 注解
 * 3，FallbackFactory 的 泛型T 要放 一个 @Feign 接口才行，
 * 4,在 DeptClientService 的@Feign注解增加 fallbackFactory=DeptClientServiceFallBackFactory.class
 * 5,microservicecloud-customer-dept-feign 服务端 的yml 添加  feign:hystrix:enabled:true注解
 * 5，这样就实现 了在客户端 统一 处理 服务熔断机制
 * 服务熔断和 服务降级 其实是同一个 意思，只不过前者实在服务端接口增加@HystrixCommand注解指定回调方法完成的，
 * 但是后者是在客户端完成的，达到的效果都是差不多的，都会返回一个缺省值，	就是说该服务 挂掉了，但是 我在 客户点这边会有 失败回调，仍然会返回信息给用户，这样 用户看到 失败的 信息，
 * 就相当于 变相的知道了该服务已经挂掉了，那么该服务用户调用的次数就会 少 了，也就相当于实现 了  服务降级。
 * 【服务熔断】
 * 一般是某个服务故障或者异常引起，类似现实世界中的保险丝，当某个异常条件被触发，直接熔断整个服务，而不是一致等待此服务直至超时。
 * 【服务降级】
 * 所谓降级，一般是从整体负荷考虑，就是当某个服务熔断之后，服务器将不在被调用，此时客户端可以自己准备一个本地的fallback 回调，返回一个缺省值，这样做
 * ，虽然服务水平下降，但好歹可用，比直接挂掉要强。
 * 
 * 
 * 
 * @author ASUS
 *
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDeptno(id).setDname("没有该部门，此时服务降级").setDb_source("no this database in mysql");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
