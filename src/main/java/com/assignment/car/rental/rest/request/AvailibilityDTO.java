package com.assignment.car.rental.rest.request;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.assignment.car.rental.entities.CurrencyCode;

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

}
