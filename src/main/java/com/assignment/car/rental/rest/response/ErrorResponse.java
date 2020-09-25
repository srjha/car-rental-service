package com.assignment.car.rental.rest.response;

public class ErrorResponse {

	private final String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
