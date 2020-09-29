package com.assignment.car.rental;

import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.car.rental.entities.Car;
import com.assignment.car.rental.entities.CarType;
import com.assignment.car.rental.repositories.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CarRepository carRepository;

	@Test
	public void ensureBasicSaveAndRetrieve() {
		// Setup
		final var car = new Car();
		car.setCarNumberPlate("abc" + new SecureRandom().nextInt(9999));
		car.setCarType(CarType.SUV);

		final var persistedCar = entityManager.persist(car);

		// Act and Assert
		assertTrue(carRepository.findById(persistedCar.getId()).isPresent());
	}

}
