package com.assignment.car.rental.entities;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.assignment.car.rental.rest.request.car.CarType;

@Entity
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String carNumberPlate;

	private CarType carType;

	private ZonedDateTime availableFrom;

	private ZonedDateTime availableTos;

	public ZonedDateTime getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(ZonedDateTime availableFrom) {
		this.availableFrom = availableFrom;
	}

	public ZonedDateTime getAvailableTos() {
		return availableTos;
	}

	public void setAvailableTos(ZonedDateTime availableTos) {
		this.availableTos = availableTos;
	}

	public String getCarNumberPlate() {
		return carNumberPlate;
	}

	public void setCarNumberPlate(String carNumberPlate) {
		this.carNumberPlate = carNumberPlate;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Long getId() {
		return id;
	}

}
