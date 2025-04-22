package com.abhi.it.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler(value = UserNotFound.class)
	public ResponseEntity<ErrorInfo> handleUNF(UserNotFound e){
		String msg = e.getMessage();
		
		ErrorInfo error = new ErrorInfo();
		error.setCode("SBI0091X");
		error.setDate(LocalDateTime.now());
		error.setMessage(msg);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception e){
		String msg = e.getMessage();
		
		ErrorInfo error = new ErrorInfo();
		error.setCode("SBI0091X");
		error.setDate(LocalDateTime.now());
		error.setMessage(msg);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
