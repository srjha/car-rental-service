package com.assignment.car.rental.rest.request.car;

import java.util.UUID;

public class CarRest {

	private UUID carId;
	private NumberPlate numberPlate;
	private CarType carType;

	public UUID getCarId() {
		return carId;
	}

	public void setCarId(UUID carId) {
		this.carId = carId;
	}

	public NumberPlate getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(NumberPlate numberPlate) {
		this.numberPlate = numberPlate;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

}
