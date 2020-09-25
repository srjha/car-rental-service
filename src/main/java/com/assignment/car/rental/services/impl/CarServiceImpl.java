package com.assignment.car.rental.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Availibility;
import com.assignment.car.rental.entities.Car;
import com.assignment.car.rental.exception.RequestEntityAlreadyExists;
import com.assignment.car.rental.repositories.CarRepository;
import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CarDTO;
import com.assignment.car.rental.services.CarService;

@Service
@Transactional
public class CarServiceImpl extends AbstractService implements CarService {

	private final CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public CarDTO save(CarDTO car) {
		final var carToBeSaved = modelMapper.map(car, Car.class);
		if (carRepository.existsByCarNumberPlateIgnoreCase(carToBeSaved.getCarNumberPlate())) {
			throw new RequestEntityAlreadyExists(
					"Car with number " + carToBeSaved.getCarNumberPlate() + " already exists.");

		}

		return modelMapper.map(carRepository.save(carToBeSaved), CarDTO.class);
	}

	@Override
	public List<CarDTO> findAll() {

		return ((List<Car>) carRepository.findAll()).stream().map(c -> modelMapper.map(c, CarDTO.class))
				.collect(Collectors.toList());

	}

	@Override
	public List<AvailibilityDTO> addAvilibility(Long carId, AvailibilityDTO availibility) {
		final var foundCar = carRepository.findById(carId);
		if (foundCar.isEmpty()) {
			throw new EntityNotFoundException("Car with id " + carId + " does not exists");
		}

		final var car = foundCar.get();
		car.addAvailibilitie(modelMapper.map(availibility, Availibility.class));
		return carRepository.save(car).getAvailibilities().stream().map(a -> modelMapper.map(a, AvailibilityDTO.class))
				.collect(Collectors.toList());

	}

}
