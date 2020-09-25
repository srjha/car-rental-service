package com.assignment.car.rental.services;

import java.util.List;

import com.assignment.car.rental.rest.request.CustomerDTO;

public interface CustomerService {

	CustomerDTO add(CustomerDTO customer);

	List<CustomerDTO> listAll();

}