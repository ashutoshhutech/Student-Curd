package com.hutech.student.exception;

import org.springframework.http.HttpStatus;

public class ConstraintViolationException extends Exception {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}

	public ConstraintViolationException(String message, HttpStatus status) {
		super();
		this.status = HttpStatus.BAD_GATEWAY;
	}
}
