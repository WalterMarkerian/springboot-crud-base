package com.apirest.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.ConvertTo;

@Service
@Validated
public class MotorcycleServiceImpl implements MotorcycleService {

	@Autowired
	private MotorcycleRepository motorcycleRepository;

	@Autowired
	private ConvertTo convertTo;

	@Override
	public List<MotorcycleDTO> getAllMotorcycles() {
		List<Motorcycle> motorcycles = motorcycleRepository.findAll();
		return motorcycles.stream().map(motorcycle -> convertTo.mapToMotorcycleDTO(motorcycle))
				.collect(Collectors.toList());
	}

	@Override
	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId) {
		List<Motorcycle> motorcycles = motorcycleRepository.findAllByCustomerCustomerId(customerId);
		return motorcycles.stream().map(convertTo::mapToMotorcycleDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<MotorcycleDTO> getMotorcycleByDomain(String domain) {
		Motorcycle motorcycle = motorcycleRepository.findByDomain(domain);

		// Convertir Motorcycle a MotorcycleDTO
		return Optional.ofNullable(convertTo.mapToMotorcycleDTO(motorcycle));
	}

//	@Override
//	public MotorcycleDTO updateMotorcycle(MotorcycleDTO updatedMotorcycleDTO) {
//		Motorcycle extistingMotorcycle = motorcycleRepository.findByDomain(updatedMotorcycleDTO.getDomain())
//				.orElseThrow(( -> new ResourceNotFoundException("")))
//		return null;
//	}

//	@Override
//	public MotorcycleDTO getMotorcycleByMotorcycleId(Long motorcycleId) {
//		Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
//				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "motorcycleId", motorcycleId));
//		return convertTo.mapToMotorcycleDTO(motorcycle);
//	}

//	
//	
//	
//	@Override
//	public MotorcycleDTO createMotorcycle(MotorcycleDTO motorcycleDTO) {
//			
//		Motorcycle motorcycle = convertTo.mapToMotorcycleEntity(motorcycleDTO);
//		Motorcycle newMotorcycle = motorcycleRepository.save(motorcycle);
//		MotorcycleDTO motorcycleResponse = convertTo.mapToMotorcycleDTO(newMotorcycle);
//		
//		return motorcycleResponse;
//	}
//
//
//

//	
//	

//
//	@Override
//	public MotorcycleDTO updateMotorcycle(MotorcycleDTO motorcycleDTO, Long motorcycleId) {
//		Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
//				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "motorcycleId", motorcycleId));
//		motorcycle.setBrand(motorcycleDTO.getBrand());
//		motorcycle.setDomain(motorcycleDTO.getDomain());
//		
//		Motorcycle motorcycleUpdated = motorcycleRepository.save(motorcycle);
//		return convertTo.mapToMotorcycleDTO(motorcycleUpdated);
//	}
//
//	@Override
//	public void deleteMotorcycleByMotorcycleId(Long motorcycleId) {
//		Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
//				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "motorcycleId", motorcycleId));
//		motorcycleRepository.delete(motorcycle);
//	}

}
