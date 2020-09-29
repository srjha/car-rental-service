package com.assignment.car.rental.rest.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.assignment.car.rental.entities.CarType;

/**
 * Car JSONs
 *
 * @author Shashi Ranjan
 *
 */
@Valid
public class CarDTO {

	private Long id;

	@NotNull
	private String carNumberPlate;

	@NotNull
	private CarType carType;

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

	@Override
	public String toString() {
		return "CarDTO [id=" + id + ", carNumberPlate=" + carNumberPlate + ", carType=" + carType + "]";
	}

}
