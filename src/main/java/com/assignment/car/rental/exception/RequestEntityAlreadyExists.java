package com.assignment.car.rental.exception;

/**
 * If an attempt is made to create entity with fileds which cannot be
 * duplicated.
 *
 * @author Shashi Ranjan
 *
 */
public class RequestEntityAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = -1256743532794847388L;

	public RequestEntityAlreadyExists(String message) {
		super(message);
	}

}
