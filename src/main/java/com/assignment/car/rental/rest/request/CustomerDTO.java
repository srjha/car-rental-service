package com.assignment.car.rental.rest.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class CustomerDTO {

	private Long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
