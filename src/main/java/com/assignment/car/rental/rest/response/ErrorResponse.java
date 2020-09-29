package com.assignment.car.rental.rest.response;

/**
 * Response JSON in case of error
 *
 * @author Shashi Ranjan
 *
 */
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
