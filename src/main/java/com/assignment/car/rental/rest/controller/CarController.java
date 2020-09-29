package com.assignment.car.rental.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CarDTO;
import com.assignment.car.rental.services.CarService;

/**
 * REST End dealing with car and related operationss
 *
 * @author Shashi Ranjan
 *
 */
@Validated
@RestController
public class CarController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/cars")
	ResponseEntity<CarDTO> createEntry(@RequestBody @Valid CarDTO car) {
		return ResponseEntity.ok(carService.save(car));

	}

	@GetMapping("/cars")
	ResponseEntity<List<CarDTO>> listAll() {
		return ResponseEntity.ok(carService.findAll());
	}

	@PostMapping("/cars/{carId}/availibilities")
	ResponseEntity<List<AvailibilityDTO>> addAvailibility(@Valid @RequestBody AvailibilityDTO availibility,
			@PathVariable("carId") Long carId) {
		return ResponseEntity.ok(carService.addAvilibility(carId, availibility));

	}

	@GetMapping("/cars/availibilities")
	ResponseEntity<List<CarDTO>> searchCar(AvailibilityDTO search) {
		LOGGER.info("Received search: {}", search);
		return ResponseEntity.ok(carService.search(search));
	}

}
