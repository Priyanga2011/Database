package com.lg.exception.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* Error response DTO */
public class ErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp = LocalDateTime.now();
	private String message;
	private String errorCode = "ERROR_001";
	@JsonIgnore
	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	public ErrorResponse(String errorCode) {
		this();
		this.errorCode = errorCode;
	}

	public ErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	public ErrorResponse(String errorCode, Throwable ex) {
		this();
		this.errorCode = errorCode;
		this.message = "Unexpected error";
		ex.printStackTrace();
	}

	public ErrorResponse(String errorCode, String message, Throwable ex) {
		this();
		this.errorCode = errorCode;
		this.message = message;
		ex.printStackTrace();
	}



	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
