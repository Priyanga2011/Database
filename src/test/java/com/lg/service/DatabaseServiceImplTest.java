package com.lg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.lg.service.impl.DatabaseServiceImpl;

@ExtendWith({ MockitoExtension.class, SpringExtension.class })
@MockitoSettings(strictness = Strictness.LENIENT)
class DatabaseServiceImplTest {

	@InjectMocks
	DatabaseServiceImpl databaseService;


	@BeforeEach
	void setup() {
		ReflectionTestUtils.setField(databaseService, "serviceUrl", "https://smarthealth-subhi.lg-apps.com/");
		ReflectionTestUtils.setField(databaseService, "cookie", "AuthSession=c3ViaGk6NUY0RTFERTk6U6XNkFb7hE41e4MzB8j-dzTKUWI; userCtx=%7B%22name%22%3A%22subhi%22%2C%22roles%22%3A%5B%22_admin%22%2C%22national_admin%22%2C%22mm-online%22%5D%7D; locale=en");
		ReflectionTestUtils.setField(databaseService, "accept", "application/json");
	}

	@Test
	void shouldReturn_Database_Response() {
		String expectedResponse = "{\"couchdb\":\"Welcome\",\"version\":\"3.1.0\",\"git_sha\":\"ff0feea20\",\"uuid\":\"a514c4236e5acfaee3e4b6db21bd0480\",\"features\":[\"access-ready\",\"partitioned\",\"pluggable-storage-engines\",\"reshard\",\"scheduler\"],\"vendor\":{\"name\":\"The Apache Software Foundation\"}} ";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders(); 
		httpHeaders.add("Cookie", databaseService.cookie);
		httpHeaders.add("Accept", databaseService.accept);
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		when(restTemplate.exchange(databaseService.serviceUrl,HttpMethod.GET, entity, String.class)
				.getBody()).thenReturn(expectedResponse);
		String actualResponse = databaseService.getDatabaseResponse();
		assertEquals(expectedResponse.trim().contains("Welcome"), actualResponse.trim().contains("Welcome"));
	}

}
