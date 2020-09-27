package com.assignment.car.rental.entities;

import javax.persistence.Entity;

@Entity
public class Customer extends AbstractEntity {
	private static final long serialVersionUID = 5493458942779884023L;

	private String firstName;

	private String lastname;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
