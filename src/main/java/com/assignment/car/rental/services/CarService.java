package com.assignment.car.rental.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.assignment.car.rental.entities.Availibility;
import com.assignment.car.rental.entities.Car;
import com.assignment.car.rental.entities.RentalOrder;
import com.assignment.car.rental.entities.RentalStatus;
import com.assignment.car.rental.exception.CannotBookRentalOrderException;
import com.assignment.car.rental.exception.RequestEntityAlreadyExists;
import com.assignment.car.rental.repositories.AvailibilityRepository;
import com.assignment.car.rental.repositories.CarRepository;
import com.assignment.car.rental.repositories.CustomerRepository;
import com.assignment.car.rental.repositories.RentalOrderRepository;
import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CarDTO;
import com.assignment.car.rental.rest.response.RentalOrderDTO;

@Service
public class CarService extends AbstractService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

	private final CarRepository carRepository;

	private final AvailibilityRepository availibilityRepository;

	private final CustomerRepository customerRepository;

	private final RentalOrderRepository rentalOrderRepository;

	public CarService(CarRepository carRepository, AvailibilityRepository availibilityRepository,
			CustomerRepository customerRepository, RentalOrderRepository rentalOrderRepository) {
		this.carRepository = carRepository;
		this.availibilityRepository = availibilityRepository;
		this.customerRepository = customerRepository;
		this.rentalOrderRepository = rentalOrderRepository;
	}

	public CarDTO save(CarDTO car) {
		final var carToBeSaved = modelMapper.map(car, Car.class);
		if (carRepository.existsByCarNumberPlateIgnoreCase(carToBeSaved.getCarNumberPlate())) {
			throw new RequestEntityAlreadyExists(
					"Car with number " + carToBeSaved.getCarNumberPlate() + " already exists.");

		}

		return modelMapper.map(carRepository.save(carToBeSaved), CarDTO.class);
	}

	public List<CarDTO> findAll() {

		return ((List<Car>) carRepository.findAll()).stream().map(c -> modelMapper.map(c, CarDTO.class))
				.collect(Collectors.toList());

	}

	public List<AvailibilityDTO> addAvilibility(Long carId, AvailibilityDTO availibility) {
		final var foundCar = carRepository.findById(carId);
		if (foundCar.isEmpty()) {
			throw new EntityNotFoundException("Car with id " + carId + " does not exists");
		}

		final var car = foundCar.get();
		car.addAvailibilitie(modelMapper.map(availibility, Availibility.class));
		return carRepository.save(car).getAvailibilities().stream().map(a -> modelMapper.map(a, AvailibilityDTO.class))
				.collect(Collectors.toList());

	}

	public List<CarDTO> search(@Valid AvailibilityDTO search) {
		final var searchResults = availibilityRepository.findByFromDateTimeAndToDateTimeAndPerHourRate(
				search.getFromDateTime(), search.getToDateTime(), search.getPerHourRate());

		LOGGER.info("Search results: {}", searchResults);
		return searchResults.stream().map(Availibility::getCar).map(c -> modelMapper.map(c, CarDTO.class))
				.collect(Collectors.toList());

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

}
