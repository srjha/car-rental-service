package com.assignment.car.rental.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Car;
import com.assignment.car.rental.exception.RequestEntityAlreadyExists;
import com.assignment.car.rental.repositories.CarRepository;
import com.assignment.car.rental.rest.request.car.CarDTO;

@Service
public class CarService {

	private final CarRepository carRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public CarDTO save(CarDTO car) {
		final var carToBeSaved = modelMapper.map(car, Car.class);
		if (carRepository.existsByCarNumberPlateIgnoreCase(carToBeSaved.getCarNumberPlate())) {
			throw new RequestEntityAlreadyExists(
					"Car with number " + carToBeSaved.getCarNumberPlate() + " already exists.");

		}

		return modelMapper.map(carRepository.save(carToBeSaved), CarDTO.class);
	}

	public List<CarDTO> findAll() {

		return ((List<Car>) carRepository.findAll()).stream().map(c -> modelMapper.map(c, CarDTO.class))
				.collect(Collectors.toList());

	}

}
