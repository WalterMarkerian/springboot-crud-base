package com.apirest.springboot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.springboot.entities.Motorcycle;


public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

	Optional<Motorcycle> findById(Long motorcycleId);
	public List<Motorcycle> findAllByCustomerCustomerId(Long customerId);	
	Motorcycle findByDomain(String domain);
	

}
