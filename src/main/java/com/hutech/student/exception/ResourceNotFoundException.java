package com.hutech.student.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}

	public ResourceNotFoundException(String message, HttpStatus status) {
		super(message);
		this.status = HttpStatus.BAD_GATEWAY;
	}

}
