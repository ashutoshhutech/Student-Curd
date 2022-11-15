package com.hutech.student.exception;

import org.springframework.http.HttpStatus;

public class HttpRequestMethodNotSupportedException extends Exception {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}

	public HttpRequestMethodNotSupportedException(String message, HttpStatus status) {
		super();
		this.status = HttpStatus.METHOD_NOT_ALLOWED;
	}
}
