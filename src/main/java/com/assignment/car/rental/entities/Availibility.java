package com.assignment.car.rental.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Availibility {

	@Id
	@GeneratedValue
	private Long id;

	private ZonedDateTime fromDateTime;

	private ZonedDateTime toDateTime;

	@ManyToOne
	private Car car;

	private BigDecimal perHourRate;

	private CurrencyCode currencyCode;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Long getId() {
		return id;
	}

	public ZonedDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(ZonedDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public ZonedDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(ZonedDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

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

}
