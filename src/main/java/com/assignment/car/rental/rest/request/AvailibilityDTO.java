package com.assignment.car.rental.rest.request;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.assignment.car.rental.entities.CurrencyCode;
import com.assignment.car.rental.entities.RentalStatus;

/**
 * Availibility JSON
 *
 * @author Shashi Ranjan
 *
 */
@Valid
public class AvailibilityDTO {

	private Long id;

	@NotNull
	private String fromDateTime;

	@NotNull
	private String toDateTime;

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

	public ZonedDateTime getFromDateTimeParsed() {
		return ZonedDateTime.parse(fromDateTime);
	}

	public ZonedDateTime getToDateTimeParsed() {
		return ZonedDateTime.parse(toDateTime);
	}

	public String getFromDateTime() {
		return fromDateTime.toString();
	}

	public String getToDateTime() {
		return toDateTime.toString();
	}

	@Override
	public String toString() {
		return "AvailibilityDTO [id=" + id + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime
				+ ", perHourRate=" + perHourRate + ", currencyCode=" + currencyCode + "]";
	}

	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}

	public RentalStatus getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(RentalStatus rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

}
