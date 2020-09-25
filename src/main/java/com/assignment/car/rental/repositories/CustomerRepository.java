package com.assignment.car.rental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.car.rental.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
