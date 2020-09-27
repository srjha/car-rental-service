package com.assignment.car.rental.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Availibility extends AbstractEntity {
	private static final long serialVersionUID = -1784886305565497951L;

	private ZonedDateTime fromDateTime;

	private ZonedDateTime toDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;

	private BigDecimal perHourRate;

	private CurrencyCode currencyCode;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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

	@Override
	public String toString() {
		return "Availibility [id=" + id + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime + ", car="
				+ car + ", perHourRate=" + perHourRate + ", currencyCode=" + currencyCode + "]";
	}

}
