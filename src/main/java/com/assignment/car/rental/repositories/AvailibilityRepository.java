package com.assignment.car.rental.repositories;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.car.rental.entities.Availibility;
import com.assignment.car.rental.entities.RentalStatus;

@Repository
public interface AvailibilityRepository extends CrudRepository<Availibility, Long> {

	@Query("SELECT a FROM Availibility a WHERE fromDateTime <= ?1 AND toDateTime >= ?2 AND perHourRate<= ?3")
	List<Availibility> findByFromDateTimeAndToDateTimeAndPerHourRate(ZonedDateTime fromDateTime,
			ZonedDateTime toDateTime, BigDecimal perHourRate);

	@Query("SELECT a FROM Availibility a WHERE car.id = ?1 AND id = ?2 AND rentalStatus = ?3")
	Availibility findByIdAndCarIdAndAvailableStatus(Long carId, Long availId, RentalStatus statuss);

}
