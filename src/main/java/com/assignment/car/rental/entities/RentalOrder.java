package com.assignment.car.rental.entities;

import javax.persistence.Entity;

@Entity
public class RentalOrder extends AbstractEntity {
	private static final long serialVersionUID = 7476546003712765703L;

	private Availibility availibility;
	private Customer customer;

}
