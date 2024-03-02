package com.apirest.springboot.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.ConvertTo;

@Service
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
//	@Override
//	public MotorcycleDTO getMotorcycleByMotorcycleId(Long motorcycleId) {
//		Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
//				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "motorcycleId", motorcycleId));
//		return convertTo.mapToMotorcycleDTO(motorcycle);
//	}
//	
//	
//	@Override
//	public MotorcycleDTO getMotorcycleByDomain(String domain) {
//		Motorcycle motorcycle = motorcycleRepository.findByDomain(domain);
////				.orElseThrow(() -> new ResourceNotFoundException(": " + domain));
//		return convertTo.mapToMotorcycleDTO(motorcycle);
//	}
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
