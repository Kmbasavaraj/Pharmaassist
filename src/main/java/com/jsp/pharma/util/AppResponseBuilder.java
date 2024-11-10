package com.jsp.pharma.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder {
	
	public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status,String massage,T data){
		return ResponseEntity.status(status).body(ResponseStructure.create(status, massage, data));
	}
	
	public <T> ResponseEntity<ErrorStructure<T>> error(HttpStatus status,String Message,T rootCause){
		return ResponseEntity.status(status).body(ErrorStructure.create(status, Message, rootCause));
	}
	
}
