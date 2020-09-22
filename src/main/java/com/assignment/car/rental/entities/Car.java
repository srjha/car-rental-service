package com.assignment.car.rental.entities;

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
