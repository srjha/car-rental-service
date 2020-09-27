package com.assignment.car.rental.rest.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.rest.response.RentalOrderDTO;
import com.assignment.car.rental.services.CarService;

@Validated
@RestController
public class RentalOrderController {

	private final CarService carService;

	public RentalOrderController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/cars/{carId}/availibilities/{availId}/order")
	ResponseEntity<RentalOrderDTO> order(@Valid @RequestBody RentalOrderDTO order, @PathVariable("carId") Long carId,
			@PathVariable("availId") Long availId, @RequestParam("custId") Long custId) {

		return ResponseEntity
				.ok(carService.book(custId, carId, availId, order.getPickupTime(), order.getDropoffTime()));

	}

}
