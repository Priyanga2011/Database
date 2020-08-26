package com.lg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DatabaseService {
	
	@Value("${service.url}")
	String serviceUrl;

	@Autowired
	RestTemplate restTemplate;
	
	public DatabaseService(RestTemplate restTemplate) {
		this.restTemplate =restTemplate;
	}

	public String getDatabaseResponse() {
		return restTemplate.getForObject(serviceUrl, String.class);
	}

}
