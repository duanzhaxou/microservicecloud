package com.atguigu.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class YmlProperties {

	@Value("${server.port}")
	private String port;
	
	private  RestTemplate  restTemplate;
	@GetMapping("/config")
   public  String  getYmlProperties() {		
		HttpHeaders headers =new HttpHeaders();
		HttpEntity<HttpHeaders> httpEntity =new HttpEntity<HttpHeaders>(headers);
		restTemplate.postForLocation("http://config-3344.com:3344/bus/refresh",httpEntity);
	   return  "port"+":"+port;
   }	
	
	@GetMapping("/refresh")
   public  String  refreshYml() {  
		System.out.println("123");
	   restTemplate.postForLocation("http://localhost:3344/bus/refresh", null);
	  return "ok"; 
   }

}
