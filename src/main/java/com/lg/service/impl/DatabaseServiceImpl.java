package com.lg.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lg.constant.ErrorMessageConstant;
import com.lg.exception.DatabaseConnectionRefuseException;
import com.lg.service.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService{

	@Value("${databaseservice.url}")
	public String serviceUrl;
	
	@Value("${databaseservice.cookie}")
	public String cookie;
	
	@Value("${databaseservice.accept}")
	public String accept;
	@Override
	public String getDatabaseResponse() {
		ResponseEntity<String> response;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("Cookie", cookie);
			httpHeaders.add("Accept", accept);
			HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
			response = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception e) {
			  throw new DatabaseConnectionRefuseException(ErrorMessageConstant.CONNECTION_REFUSED);
		}
		return response.getBody();
	}

}
