package com.apirest.springboot.translator;

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
		return motorcycleDTO;
	}
	
	public Motorcycle toEntity(MotorcycleDTO motorcycleDTO) {
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.setId(motorcycleDTO.getId());
		motorcycle.setBrand(motorcycleDTO.getBrand());
		motorcycle.setDomain(motorcycleDTO.getDomain());
		return motorcycle;
	}

}
