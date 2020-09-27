package com.assignment.car.rental.rest.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.rental.rest.response.RentalOrderDTO;
import com.assignment.car.rental.rest.response.Report;
import com.assignment.car.rental.rest.response.ReportType;
import com.assignment.car.rental.services.RentalBookingService;

@Validated
@RestController
public class RentalOrderController {

	private final RentalBookingService rentalOrderService;

	public RentalOrderController(RentalBookingService carService) {
		rentalOrderService = carService;
	}

	@PostMapping("/cars/{carId}/availibilities/{availId}/order")
	ResponseEntity<RentalOrderDTO> order(@Valid @RequestBody RentalOrderDTO order, @PathVariable("carId") Long carId,
			@PathVariable("availId") Long availId, @RequestParam("custId") Long custId) {

		return ResponseEntity
				.ok(rentalOrderService.book(custId, carId, availId, order.getPickupTime(), order.getDropoffTime()));

	}

	@GetMapping("/orders")
	ResponseEntity<Report> search(@Valid RentalOrderDTO order,
			@RequestParam(name = "intervalInHr", required = false) Integer intervalInHr) {
		return ResponseEntity.ok(new Report(ReportType.BOOKED_CAR_DETAILS,
				rentalOrderService.search(order.getPickupTime(), order.getDropoffTime())));
	}

}
