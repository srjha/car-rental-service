package com.assignment.car.rental.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class RentalOrder extends AbstractEntity {
	private static final long serialVersionUID = 7476546003712765703L;

	@OneToOne
	@JoinColumn(name = "availibility_id", referencedColumnName = "id")
	private Availibility availibility;

	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	private BigDecimal totalCost;

	private ZonedDateTime pickupTime;

	private ZonedDateTime dropoffTime;

	public ZonedDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(ZonedDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public ZonedDateTime getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(ZonedDateTime dropoffTime) {
		this.dropoffTime = dropoffTime;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	@PrePersist
	@PreUpdate
	public void calcTotalCost() {
		totalCost = availibility.getPerHourRate()
				.multiply(BigDecimal.valueOf(Duration.between(dropoffTime, pickupTime).toHours()));
	}

	public Availibility getAvailibility() {
		return availibility;
	}

	public void setAvailibility(Availibility availibility) {
		this.availibility = availibility;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
