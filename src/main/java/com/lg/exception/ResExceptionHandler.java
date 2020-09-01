package com.lg.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lg.constant.ErrorMessageConstant;
import com.lg.exception.models.ErrorResponse;
/* Exceptions were handled in this class */
@ControllerAdvice
public class ResExceptionHandler extends ResponseEntityExceptionHandler {

	/* Status code 400 is handled in this request */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ErrorMessageConstant.BAD_REQUEST_ERROR;
		return buildResponseEntity(new ErrorResponse(ErrorMessageConstant.ERRORCODE_002, error, ex));
	}
	

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse responseError) {
		return new ResponseEntity<>(responseError, responseError.getStatus());
	}

	/* Couch db connection refused, exception handled 
	 * in this method
	 */
	@ExceptionHandler(DatabaseConnectionRefuseException.class)
	protected ResponseEntity<Object> handleDatabaseConRefuseException(DatabaseConnectionRefuseException ex) {
		ErrorResponse responseError = new ErrorResponse(ErrorMessageConstant.ERRORCODE_001);
		responseError.setMessage(ErrorMessageConstant.CONNECTION_REFUSED);
		return buildResponseEntity(responseError);
	}	
}