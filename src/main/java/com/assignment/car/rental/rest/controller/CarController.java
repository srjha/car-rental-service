package com.assignment.car.rental.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.rest.request.car.CarDTO;
import com.assignment.car.rental.services.CarService;

@RestController
public class CarController {

	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/cars")
	ResponseEntity<CarDTO> createEntry(@RequestBody CarDTO car) {
		return ResponseEntity.ok(carService.save(car));

	}

	@GetMapping("/cars")
	ResponseEntity<List<CarDTO>> listAll() {
		return ResponseEntity.ok(carService.findAll());
	}

}
