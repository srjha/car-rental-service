package com.assignment.car.rental.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.RentalOrder;
import com.assignment.car.rental.entities.RentalStatus;
import com.assignment.car.rental.exception.CannotBookRentalOrderException;
import com.assignment.car.rental.repositories.AvailibilityRepository;
import com.assignment.car.rental.repositories.CustomerRepository;
import com.assignment.car.rental.repositories.RentalOrderRepository;
import com.assignment.car.rental.rest.response.RentalOrderDTO;

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

		return modelMapper.map(savedOrder, RentalOrderDTO.class);
	}

	public List<RentalOrderDTO> search(ZonedDateTime pickupTime, ZonedDateTime dropoffTime) {
		return rentalOrderRepository.findWithPickupAndDropTime(pickupTime, dropoffTime).stream()
				.map(o -> modelMapper.map(o, RentalOrderDTO.class)).collect(Collectors.toList());
	}

}
