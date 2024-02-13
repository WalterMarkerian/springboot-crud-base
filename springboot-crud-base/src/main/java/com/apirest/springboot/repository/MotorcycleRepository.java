package com.apirest.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.springboot.entities.Motorcycle;


public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

	public List<Motorcycle> findByCustomerId(Long customerId);
	
	public Motorcycle findByDomain(String domain);
	

}
