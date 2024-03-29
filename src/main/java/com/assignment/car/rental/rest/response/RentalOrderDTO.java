package com.assignment.car.rental.rest.response;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CustomerDTO;

/**
 * Rental order JSON
 *
 * @author Shashi Ranjan
 *
 */
@Validated
public class RentalOrderDTO {

	private AvailibilityDTO availibility;

	private CustomerDTO customer;

	private BigDecimal totalCost;

	@NotNull
	private ZonedDateTime pickupTime;

	@NotNull
	private ZonedDateTime dropoffTime;

	public AvailibilityDTO getAvailibility() {
		return availibility;
	}

	public void setAvailibility(AvailibilityDTO availibility) {
		this.availibility = availibility;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public ZonedDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = ZonedDateTime.parse(pickupTime);
	}

	public ZonedDateTime getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(String dropoffTime) {
		this.dropoffTime = ZonedDateTime.parse(dropoffTime);
	}

	@Override
	public String toString() {
		return "RentalOrderDTO [availibility=" + availibility + ", customer=" + customer + ", totalCost=" + totalCost
				+ ", pickupTime=" + pickupTime + ", dropoffTime=" + dropoffTime + "]";
	}

}
