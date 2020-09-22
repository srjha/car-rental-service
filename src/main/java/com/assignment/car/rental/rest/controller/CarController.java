package com.assignment.car.rental.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.CarService;
import com.assignment.car.rental.entities.Car;

@RestController
public class CarController {

	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/cars")
	ResponseEntity<Car> createEntry(@RequestBody Car car) {
		return ResponseEntity.ok(carService.save(car));

	}

	@GetMapping("/cars")
	ResponseEntity<Iterable<Car>> listAll() {
		return ResponseEntity.ok(carService.findAll());
	}

}
