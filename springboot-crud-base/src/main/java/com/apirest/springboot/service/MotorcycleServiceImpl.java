package com.apirest.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.ConvertMotorcycle;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {
	
	@Autowired
	private MotorcycleRepository motorcycleRepository;
	
	@Autowired
	private ConvertMotorcycle convertMotorcycle;

	@Override
	public MotorcycleDTO createMotorcycle(MotorcycleDTO motorcycleDTO) {
			
		Motorcycle motorcycle = convertMotorcycle.toEntity(motorcycleDTO);
		Motorcycle newMotorcycle = motorcycleRepository.save(motorcycle);
		MotorcycleDTO motorcycleResponse = convertMotorcycle.toDTO(newMotorcycle);
		
		return motorcycleResponse;
	}

	@Override
	public List<MotorcycleDTO> getAllMotorcycles() {
		List<Motorcycle> motorcycles = motorcycleRepository.findAll();
		return motorcycles.stream().map(motorcycle -> convertMotorcycle.toDTO(motorcycle))
				.collect(Collectors.toList());
	}

	@Override
	public MotorcycleDTO getMotorcycleById(Long id) {
		Motorcycle motorcycle = motorcycleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
		return convertMotorcycle.toDTO(motorcycle);
	}

	@Override
	public MotorcycleDTO updateMotorcycle(MotorcycleDTO motorcycleDTO, Long id) {
		Motorcycle motorcycle = motorcycleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
		motorcycle.setBrand(motorcycleDTO.getBrand());
		motorcycle.setDomain(motorcycleDTO.getDomain());
		
		Motorcycle motorcycleUpdated = motorcycleRepository.save(motorcycle);
		return convertMotorcycle.toDTO(motorcycleUpdated);
	}

	@Override
	public void deleteMotorcycleById(Long id) {
		Motorcycle motorcycle = motorcycleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
		motorcycleRepository.delete(motorcycle);
	}

}
