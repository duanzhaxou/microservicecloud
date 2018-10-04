package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private String port;

	@GetMapping("/config")
	public  String getConfig() {
		return "ConfigClientRest [applicationName=" + applicationName + ", eurekaServers=" + eurekaServers + ", port="
				+ port + "]";
	}
	
	
	@Override
	public String toString() {
		return "ConfigClientRest [applicationName=" + applicationName + ", eurekaServers=" + eurekaServers + ", port="
				+ port + "]";
	}


	public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	public String getEurekaServers() {
		return eurekaServers;
	}


	public void setEurekaServers(String eurekaServers) {
		this.eurekaServers = eurekaServers;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}
     
	
    
	


}
