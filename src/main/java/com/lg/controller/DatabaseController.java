package com.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lg.service.impl.DatabaseServiceImpl;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
public class DatabaseController {

	private DatabaseServiceImpl databaseService;

	@Autowired
	public DatabaseController(DatabaseServiceImpl databaseService) {
		this.databaseService = databaseService;
	}

	@GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Database Information", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved DB Information"),
			@ApiResponse(code = 500, message = "Problem in getting the DB Information") })
	@ResponseBody
	public ResponseEntity<String> getDatabaseResponse() {
		return new ResponseEntity<>(databaseService.getDatabaseResponse(), HttpStatus.OK);
	}

}
