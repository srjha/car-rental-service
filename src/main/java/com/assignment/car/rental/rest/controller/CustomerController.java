package com.assignment.car.rental.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.rest.request.CustomerDTO;
import com.assignment.car.rental.services.CustomerService;

/**
 * Rest end for customer and related operations
 *
 * @author Shashi Ranjan
 *
 */
@Validated
@RestController
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	ResponseEntity<List<CustomerDTO>> get() {
		return ResponseEntity.ok(customerService.listAll());
	}

	@PostMapping("/customers")
	ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customer) {
		return ResponseEntity.ok(customerService.add(customer));
	}

}
