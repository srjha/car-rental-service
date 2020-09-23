package com.assignment.car.rental.exception;

public class RequestEntityAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = -1256743532794847388L;

	public RequestEntityAlreadyExists(String message) {
		super(message);
	}

}
