package com.assignment.car.rental.rest.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * Report DTO
 *
 * @author Shashi Ranjan
 *
 */
public class Report {

	private List<RentalOrderDTO> rentals;

	private Integer totalCarsBooked;

	private BigDecimal totalPayment;

	public Report(List<RentalOrderDTO> rentals) {
		super();
		this.rentals = rentals;
	}

	public List<RentalOrderDTO> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentalOrderDTO> rentals) {
		this.rentals = rentals;
	}

	public Integer getTotalCarsBooked() {
		return totalCarsBooked;
	}

	public void setTotalCarsBooked(Integer totalCarsBooked) {
		this.totalCarsBooked = totalCarsBooked;
	}

	public BigDecimal getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(BigDecimal totalPayment) {
		this.totalPayment = totalPayment;
	}

}
