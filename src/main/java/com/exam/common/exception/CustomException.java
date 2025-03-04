package com.exam.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;

	public CustomException(String message) {
		this.message = message;
	}

	public CustomException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

}
