package com.assignment.car.rental.services;

import java.util.List;

import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CarDTO;

public interface CarService {

	CarDTO save(CarDTO car);

	List<CarDTO> findAll();

	List<AvailibilityDTO> addAvilibility(Long carId, AvailibilityDTO availibility);

}