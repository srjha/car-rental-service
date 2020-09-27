package com.assignment.car.rental.rest.response;

import java.util.List;

public class Report {
	private ReportType reportType;

	private List<RentalOrderDTO> rentals;

	public Report(ReportType reportType, List<RentalOrderDTO> rentals) {
		super();
		this.reportType = reportType;
		this.rentals = rentals;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public List<RentalOrderDTO> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentalOrderDTO> rentals) {
		this.rentals = rentals;
	}

}
