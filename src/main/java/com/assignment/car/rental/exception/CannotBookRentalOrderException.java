package com.assignment.car.rental.exception;

public class CannotBookRentalOrderException extends RuntimeException {
	private static final long serialVersionUID = 6638813168365670085L;

	public CannotBookRentalOrderException(String message) {
		super(message);
	}

}
