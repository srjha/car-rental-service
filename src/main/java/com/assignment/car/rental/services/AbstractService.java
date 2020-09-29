package com.assignment.car.rental.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Payload/Logic common to all services
 *
 * @author Shashi Ranjan
 *
 */
public abstract class AbstractService {

	@Autowired
	protected ModelMapper modelMapper;

}
