package com.assignment.car.rental.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Customer;
import com.assignment.car.rental.repositories.CustomerRepository;
import com.assignment.car.rental.rest.request.CustomerDTO;

/**
 * Service dealing with customer domains
 *
 * @author Shashi Ranjan
 *
 */
@Service
@Transactional
public class CustomerService extends AbstractService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public CustomerDTO add(CustomerDTO customer) {
		return modelMapper.map(customerRepository.save(modelMapper.map(customer, Customer.class)), CustomerDTO.class);
	}

	public List<CustomerDTO> listAll() {
		return ((List<Customer>) customerRepository.findAll()).stream().map(c -> modelMapper.map(c, CustomerDTO.class))
				.collect(Collectors.toList());
	}

}
