package com.jsp.pharma.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.pharma.exception.AdminNotFoundByIdException;
import com.jsp.pharma.exception.AdminNotFoundException;
import com.jsp.pharma.util.AppResponseBuilder;
import com.jsp.pharma.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
	private final AppResponseBuilder errorBuilder;

	public AdminExceptionHandler(AppResponseBuilder errorBuilder) {
		super();
		this.errorBuilder = errorBuilder;
	}
	
	@ExceptionHandler(AdminNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundById(AdminNotFoundByIdException ex){
		return errorBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin Not Found By Requested Id in The Database");
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFound(AdminNotFoundException ex){
		return errorBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin Not Found By Requested Id in The Database");
	}

}
