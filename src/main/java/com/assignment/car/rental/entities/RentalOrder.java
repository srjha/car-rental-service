package com.assignment.car.rental.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RentalOrder extends AbstractEntity {
	private static final long serialVersionUID = 7476546003712765703L;

	@OneToOne
	@JoinColumn(name = "availibility_id", referencedColumnName = "id")
	private Availibility availibility;

	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

}
