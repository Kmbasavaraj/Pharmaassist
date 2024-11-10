package com.jsp.pharma.exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException{
	
	private String message;

	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
