package com.assignment.car.rental.services;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.RentalOrder;
import com.assignment.car.rental.entities.RentalStatus;
import com.assignment.car.rental.exception.CannotBookRentalOrderException;
import com.assignment.car.rental.repositories.AvailibilityRepository;
import com.assignment.car.rental.repositories.CustomerRepository;
import com.assignment.car.rental.repositories.RentalOrderRepository;
import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CustomerDTO;
import com.assignment.car.rental.rest.response.RentalOrderDTO;
import com.assignment.car.rental.rest.response.Report;

/**
 * Service dealing with booking.
 *
 * @author Shashi Ranjan
 *
 */
@Service
public class RentalBookingService extends AbstractService {

	private final CustomerRepository customerRepository;

	private final RentalOrderRepository rentalOrderRepository;

	private final AvailibilityRepository availibilityRepository;

	public RentalBookingService(CustomerRepository customerRepository, RentalOrderRepository rentalOrderRepository,
			AvailibilityRepository availibilityRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalOrderRepository = rentalOrderRepository;
		this.availibilityRepository = availibilityRepository;
	}

	public RentalOrderDTO book(Long custId, Long carId, Long availId, ZonedDateTime pickupTime,
			ZonedDateTime dropoffTime) {
		final var customer = customerRepository.findById(custId).get();
		final var foundAvail = availibilityRepository.findByIdAndCarIdAndAvailableStatus(carId, availId,
				RentalStatus.AVAILABLE);

		if (null == foundAvail) {
			throw new CannotBookRentalOrderException("No available slot with id " + availId + " for car id " + carId
					+ " in status " + RentalStatus.AVAILABLE);
		}

		final var order = new RentalOrder();
		order.setCustomer(customer);
		order.setAvailibility(foundAvail);
		order.setDropoffTime(dropoffTime);
		order.setPickupTime(pickupTime);

		final var savedOrder = rentalOrderRepository.save(order);
		foundAvail.setRentalStatus(RentalStatus.BOOKED);

		return map(savedOrder);
	}

	public Report search(ZonedDateTime pickupTime, ZonedDateTime dropoffTime) {

		final var orders = rentalOrderRepository.findWithPickupAndDropTime(pickupTime, dropoffTime);
		final var report = new Report(orders.stream().map(this::map).collect(Collectors.toList()));

		report.setTotalCarsBooked(orders.size());
		report.setTotalPayment(
				orders.parallelStream().map(RentalOrder::getTotalCost).reduce(BigDecimal.ZERO, BigDecimal::add));

		return report;
	}

	private RentalOrderDTO map(RentalOrder o) {
		final var orderDTO = modelMapper.map(o, RentalOrderDTO.class);
		orderDTO.setAvailibility(modelMapper.map(o.getAvailibility(), AvailibilityDTO.class));
		orderDTO.setCustomer(modelMapper.map(o.getCustomer(), CustomerDTO.class));

		return orderDTO;
	}

}
