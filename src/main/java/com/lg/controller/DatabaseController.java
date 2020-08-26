package com.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.service.DatabaseService;

@RestController
@RequestMapping(value = "${service.databaseService}")
public class DatabaseController {
	
	private DatabaseService databaseService;
	
	@Autowired
	public DatabaseController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@GetMapping(value = "/info")
	public String getDatabaseResponse() {
		return databaseService.getDatabaseResponse();
	
	}

}
