package com.assignment.car.rental.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Customer;
import com.assignment.car.rental.repositories.CustomerRepository;
import com.assignment.car.rental.rest.request.CustomerDTO;
import com.assignment.car.rental.services.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl extends AbstractService implements CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerDTO add(CustomerDTO customer) {
		return modelMapper.map(customerRepository.save(modelMapper.map(customer, Customer.class)), CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> listAll() {
		return ((List<Customer>) customerRepository.findAll()).stream().map(c -> modelMapper.map(c, CustomerDTO.class))
				.collect(Collectors.toList());
	}

}
