package com.lg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lg.service.DatabaseService;


@TestPropertySource(locations="src/main/resources/test.properties")
@ContextConfiguration
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
class DatabaseControllerTest {

	@Mock
	private DatabaseService databaseService;

	@InjectMocks
	private DatabaseController databaseController;

	@Autowired
	public MockMvc mockMvc;


	@BeforeEach
	void setUp() throws Exception {

		databaseController = new DatabaseController(databaseService);
		mockMvc = MockMvcBuilders.standaloneSetup(databaseController).build();
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
