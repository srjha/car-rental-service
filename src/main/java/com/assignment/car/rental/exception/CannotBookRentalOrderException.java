package com.assignment.car.rental.exception;

/**
 * If booking fails due to any unfulfilled pre-req
 *
 * @author Shashi Ranjan
 *
 */
public class CannotBookRentalOrderException extends RuntimeException {
	private static final long serialVersionUID = 6638813168365670085L;

	public CannotBookRentalOrderException(String message) {
		super(message);
	}

}
