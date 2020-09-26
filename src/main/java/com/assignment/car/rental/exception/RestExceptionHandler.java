package com.assignment.car.rental.exception;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.assignment.car.rental.rest.response.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = { RequestEntityAlreadyExists.class })
	protected ResponseEntity<ErrorResponse> handle(RequestEntityAlreadyExists ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage()));

	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	protected ResponseEntity<ErrorResponse> handle(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));

	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	protected ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));

	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<ErrorResponse> handle(ConstraintViolationException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));

	}

	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
	protected ResponseEntity<ErrorResponse> handle(MethodArgumentTypeMismatchException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));

	}

}
