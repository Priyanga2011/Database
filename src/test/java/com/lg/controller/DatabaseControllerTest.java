package com.lg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lg.DatabaseApplication;
import com.lg.service.impl.DatabaseServiceImpl;

@ExtendWith({ MockitoExtension.class, SpringExtension.class })
@TestPropertySource(locations = { "classpath:application.yml" })
@SpringBootTest(classes = DatabaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DatabaseControllerTest {

	@Mock
	private DatabaseServiceImpl databaseService;

	@InjectMocks
	private DatabaseController databaseController;

	public MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		databaseController = new DatabaseController(databaseService);
		mockMvc = MockMvcBuilders.standaloneSetup(databaseController)
				.addPlaceholderValue("service.databaseService", "/database-service")
				.build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getDatabaseResponse() {
		String actualObj = "Result";
		when(databaseService.getDatabaseResponse()).thenReturn(actualObj);
		String expectedObj = databaseService.getDatabaseResponse();
		assertEquals(expectedObj, actualObj);
	}

}
