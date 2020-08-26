package com.lg.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DatabaseService {
	
	@Value("${service.url}")
	private String url;

	public String getDatabaseResponse() {
		RestTemplate rest = new RestTemplate();
		return rest.getForObject(url, String.class);
	}

}
