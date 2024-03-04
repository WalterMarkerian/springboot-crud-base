package com.apirest.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.springboot.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findById(Long customerId);

	Optional<Customer> findByDni(String dni);

}
