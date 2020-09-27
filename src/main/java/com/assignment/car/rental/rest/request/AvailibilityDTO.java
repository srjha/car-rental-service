package com.assignment.car.rental.rest.request;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.assignment.car.rental.entities.CurrencyCode;
import com.assignment.car.rental.entities.RentalStatus;

@Valid
public class AvailibilityDTO {

	private Long id;

	@NotNull
	private ZonedDateTime fromDateTime;

	@NotNull
	private ZonedDateTime toDateTime;

	@NotNull
	private BigDecimal perHourRate;

	private CurrencyCode currencyCode = CurrencyCode.SEK;

	private RentalStatus rentalStatus = RentalStatus.AVAILABLE;

	public BigDecimal getPerHourRate() {
		return perHourRate;
	}

	public void setPerHourRate(BigDecimal perHourRate) {
		this.perHourRate = perHourRate;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getFromDateTime() {
		return fromDateTime;
	}

	public ZonedDateTime getToDateTime() {
		return toDateTime;
	}

	@Override
	public String toString() {
		return "AvailibilityDTO [id=" + id + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime
				+ ", perHourRate=" + perHourRate + ", currencyCode=" + currencyCode + "]";
	}

	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = ZonedDateTime.parse(fromDateTime);
	}

	public void setToDateTime(String toDateTime) {
		this.toDateTime = ZonedDateTime.parse(toDateTime);
	}

	public RentalStatus getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(RentalStatus rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

}
