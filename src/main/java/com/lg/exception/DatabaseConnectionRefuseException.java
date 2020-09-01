package com.lg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DatabaseConnectionRefuseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseConnectionRefuseException(String message) {
		super(message);
	}


}
