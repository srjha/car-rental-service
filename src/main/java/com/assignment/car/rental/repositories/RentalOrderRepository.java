package com.assignment.car.rental.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.assignment.car.rental.entities.RentalOrder;

public interface RentalOrderRepository extends CrudRepository<RentalOrder, Long> {

	@Query("SELECT o FROM RentalOrder o WHERE pickupTime <= ?1 AND dropoffTime >= ?2 ")
	List<RentalOrder> findWithPickupAndDropTime(ZonedDateTime pickupTime, ZonedDateTime dropoffTime);

}
