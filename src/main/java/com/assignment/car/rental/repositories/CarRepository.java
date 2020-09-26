package com.assignment.car.rental.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.car.rental.entities.Availibility;
import com.assignment.car.rental.entities.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

	boolean existsByCarNumberPlateIgnoreCase(String carNumberPlate);

	List<Car> findByAvailibilities(Availibility availibility);

}
