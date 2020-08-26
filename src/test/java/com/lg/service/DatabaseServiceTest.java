package com.lg.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
@ExtendWith({ MockitoExtension.class, SpringExtension.class })
class DatabaseServiceTest {
	
	
	@InjectMocks
	DatabaseService databaseService;
	
	
	@Mock
	RestTemplate restTemplate;
	
	@BeforeEach
    void setup() {        
        databaseService = new DatabaseService(restTemplate);
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(databaseService, "serviceUrl", "http://localhost:5984");
        
    }

	@Test
	void shouldReturn_Database_Response() {
		String expectedResponse = "Result";
		when(restTemplate.getForObject(databaseService.serviceUrl, String.class)).thenReturn(expectedResponse);
		String actualResponse = databaseService.getDatabaseResponse();
		assertEquals(expectedResponse, actualResponse);
	}

}
