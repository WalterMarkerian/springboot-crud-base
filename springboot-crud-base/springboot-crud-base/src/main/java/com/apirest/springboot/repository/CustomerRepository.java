package com.apirest.springboot.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.springboot.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
//	@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.motorcycles")
//	List<Customer> findAllWithMotorcycles();
    Optional<Customer> findById(Long customerId);

	

}
