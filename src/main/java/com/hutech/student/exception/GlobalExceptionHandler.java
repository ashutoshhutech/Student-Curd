package com.hutech.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.ConstraintViolationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleInvalidArgument(MethodArgumentNotValidException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleBusinessException(MethodArgumentNotValidException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> methodNotSupportedException(HttpRequestMethodNotSupportedException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
