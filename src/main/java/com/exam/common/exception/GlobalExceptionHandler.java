package com.exam.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exam.common.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ApiResponse.builder().message(ex.getMessage()).success(false).build(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiResponse> customException(String message, HttpStatus status) {
		return new ResponseEntity<>(ApiResponse.builder().message(message).success(true).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
