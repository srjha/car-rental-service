package com.assignment.car.rental.repositories;

import org.springframework.data.repository.CrudRepository;

import com.assignment.car.rental.entities.RentalOrder;

public interface RentalOrderRepository extends CrudRepository<RentalOrder, Long> {

}
