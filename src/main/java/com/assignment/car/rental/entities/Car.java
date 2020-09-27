package com.assignment.car.rental.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Car extends AbstractEntity {

	private String carNumberPlate;

	private CarType carType;

	@OneToMany(mappedBy = "car")
	@Cascade(CascadeType.ALL)
	private final Set<Availibility> availibilities = new HashSet<>();

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

	public Set<Availibility> getAvailibilities() {
		return availibilities;
	}

	public void addAvailibilitie(Availibility availibility) {
		availibilities.add(availibility);
		availibility.setCar(this);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carNumberPlate=" + carNumberPlate + ", carType=" + carType + "]";
	}
}
