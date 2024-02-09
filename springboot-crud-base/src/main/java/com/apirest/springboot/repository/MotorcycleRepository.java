package com.apirest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.springboot.entities.Motorcycle;


public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

}
