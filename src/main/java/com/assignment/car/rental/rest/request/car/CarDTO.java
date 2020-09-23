package com.assignment.car.rental.rest.request.car;

import java.time.ZonedDateTime;

public class CarDTO {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
