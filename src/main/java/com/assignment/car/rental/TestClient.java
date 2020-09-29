package com.assignment.car.rental;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.assignment.car.rental.entities.CarType;
import com.assignment.car.rental.entities.CurrencyCode;
import com.assignment.car.rental.rest.request.AvailibilityDTO;
import com.assignment.car.rental.rest.request.CarDTO;
import com.assignment.car.rental.rest.request.CustomerDTO;
import com.assignment.car.rental.rest.response.RentalOrderDTO;

@Component
public class TestClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestClient.class);

	private static final int MAX_TEST_ITERATION_COUNT = 10;

	private static final String BASE_URL = "http://localhost:8080";
	private static final String CARS_API = BASE_URL + "/cars";
	private static final String CUSTOMER_API = BASE_URL + "/customers";
	private static final String ADD_AVAIL_API = CARS_API + "/{carId}" + "/availibilities";
	private static final String BOOK_RENTAL_API = BASE_URL
			+ "/cars/{carId}/availibilities/{availId}/order?custId={customerId}";

	private final RestTemplate restTemplate;

	public TestClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	@EventListener
	public void startTest(ApplicationReadyEvent appReady) {

		final var executor = Executors.newScheduledThreadPool(10);

		for (var i = 1; i <= MAX_TEST_ITERATION_COUNT; i++) {
			LOGGER.info("Starting iteration {}", i);
			executor.submit(this::runIteration);

		}

		LOGGER.info("Test completed");
		executor.shutdown();

	}

	private void runIteration() {

		final var carId = createCar();

		final var availableFrom = ZonedDateTime.now().plusDays(5);
		final var availableTill = ZonedDateTime.now().plusDays(10);
		final var availId = addAvailibility(carId, availableFrom, availableTill);

		final var custId = addCustomer();
		book(availableFrom, availableTill, carId, availId, custId);
	}

	private void book(ZonedDateTime availableFrom, ZonedDateTime availableTill, Long carId, Long availId, Long custId) {
		final var rentalReq = new RentalOrderDTO();
		rentalReq.setPickupTime(availableFrom.toString());
		rentalReq.setDropoffTime(availableTill.toString());
		final var resp = restTemplate.postForEntity(BOOK_RENTAL_API, rentalReq, RentalOrderDTO.class, carId, availId,
				custId);

		LOGGER.info(BOOK_RENTAL_API + " response: {}", resp.getBody());
	}

	private Long addCustomer() {

		final var customer = new CustomerDTO();
		customer.setEmail("abc" + new SecureRandom().nextInt(999) + "@xyzabc.com");
		customer.setFirstName("goodname" + new SecureRandom().nextInt(999));
		customer.setLastname("niceLastname" + new SecureRandom().nextInt(999));

		final var carsApiResponse = restTemplate.postForEntity(CUSTOMER_API, customer, CustomerDTO.class);
		LOGGER.info(CUSTOMER_API + " response: {}", carsApiResponse.getBody());

		return carsApiResponse.getBody().getId();

	}

	private Long addAvailibility(Long carId, ZonedDateTime availableFrom, ZonedDateTime availableTill) {
		final var availibility = new AvailibilityDTO();
		availibility.setCurrencyCode(CurrencyCode.SEK);
		availibility.setFromDateTime(availableFrom.toString());
		availibility.setPerHourRate(BigDecimal.TEN);
		availibility.setToDateTime(availableTill.toString());

		final var availApiResp = restTemplate.postForEntity(ADD_AVAIL_API, availibility, AvailibilityDTO[].class,
				carId);
		LOGGER.info(ADD_AVAIL_API + " response: {}", availApiResp.getBody()[0]);

		return availApiResp.getBody()[0].getId();
	}

	private Long createCar() {
		final var car = new CarDTO();
		car.setCarNumberPlate("abc" + new SecureRandom().nextInt(9999));
		car.setCarType(CarType.SUV);

		final var carsApiResponse = restTemplate.postForEntity(CARS_API, car, CarDTO.class);
		LOGGER.info(CARS_API + " response: {}", carsApiResponse.getBody());

		return carsApiResponse.getBody().getId();
	}

}
