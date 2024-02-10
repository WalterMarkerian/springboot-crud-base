package com.apirest.springboot.utils;

import org.springframework.stereotype.Component;

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Motorcycle;

@Component
public class ConvertMotorcycle {
	
	public MotorcycleDTO toDTO(Motorcycle motorcycle) {
		MotorcycleDTO motorcycleDTO = new MotorcycleDTO();
		motorcycleDTO.setId(motorcycle.getId());
		motorcycleDTO.setBrand(motorcycle.getBrand());
		motorcycleDTO.setDomain(motorcycle.getDomain());
		motorcycleDTO.setModel(motorcycle.getModel());
		motorcycleDTO.setCylinder(motorcycle.getCylinder());
		motorcycleDTO.setYear(motorcycle.getYear());
		motorcycleDTO.setKilometers(motorcycle.getKilometers());
		motorcycleDTO.setComment(motorcycle.getComment());
		motorcycleDTO.setChassis(motorcycle.getChassis());
		motorcycleDTO.setMotorNumber(motorcycle.getMotorNumber());
	
		return motorcycleDTO;
	}
	
	public Motorcycle toEntity(MotorcycleDTO motorcycleDTO) {
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.setId(motorcycleDTO.getId());
		motorcycle.setBrand(motorcycleDTO.getBrand());
		motorcycle.setDomain(motorcycleDTO.getDomain());
		motorcycle.setModel(motorcycleDTO.getModel());
		motorcycle.setCylinder(motorcycleDTO.getCylinder());
		motorcycle.setYear(motorcycleDTO.getYear());
		motorcycle.setKilometers(motorcycleDTO.getKilometers());
		motorcycle.setComment(motorcycleDTO.getComment());
		motorcycle.setChassis(motorcycleDTO.getChassis());
		motorcycle.setMotorNumber(motorcycleDTO.getMotorNumber());
		return motorcycle;
	}

}
