package com.assignment.car.rental.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Bean;
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
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Validated
@RestController
public class CarController {

	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/cars")
	ResponseEntity<CarDTO> createEntry(@Valid @RequestBody CarDTO car) {
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

	@Bean
	public static ObjectMapper objectMapper() {

		final var mapper = new ObjectMapper();
		// mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,
		// true);
		mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE));
		// mapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		return mapper;
	}

}
