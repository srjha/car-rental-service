package com.assignment.car.rental;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Car;
import com.assignment.car.rental.repositories.CarRepository;

@Service
public class CarService {

	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car save(Car car) {
		return carRepository.save(car);
	}

	public Iterable<Car> findAll() {
		return carRepository.findAll();
	}
}
