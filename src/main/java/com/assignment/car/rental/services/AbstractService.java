package com.assignment.car.rental.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

	@Autowired
	protected ModelMapper modelMapper;

}
