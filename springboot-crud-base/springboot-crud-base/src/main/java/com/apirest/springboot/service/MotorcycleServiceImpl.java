package com.apirest.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.DefaultValues;
import com.apirest.springboot.utils.Utils;

import jakarta.transaction.Transactional;

@Service
@Validated
public class MotorcycleServiceImpl implements MotorcycleService {

	@Autowired
	private MotorcycleRepository motorcycleRepository;

	@Autowired
	private Utils utils;

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
	@Override
	public List<MotorcycleDTO> getAllMotorcycles() {
		List<Motorcycle> motorcycles = motorcycleRepository.findAll();
		return motorcycles.stream().map(motorcycle -> utils.mapToMotorcycleDTO(motorcycle))
				.collect(Collectors.toList());
	}

	@Override
	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId) {
		List<Motorcycle> motorcycles = motorcycleRepository.findAllByCustomerCustomerId(customerId);
		return motorcycles.stream().map(utils::mapToMotorcycleDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<MotorcycleDTO> getMotorcycleByDomain(String domain) {
		Motorcycle motorcycle = motorcycleRepository.findByDomain(domain)
				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "domain", domain));

		return Optional.ofNullable(utils.mapToMotorcycleDTO(motorcycle));
	}

	@Override
	@Transactional
	public void deleteMotorcycleByMotorcycleId(String domain) {
		Motorcycle motorcycle = motorcycleRepository.findByDomain(domain)
				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "domain", domain));
		motorcycleRepository.delete(motorcycle);
	}

	@Override
	@Transactional
	public MotorcycleDTO updateMotorcycle(MotorcycleDTO updatedMotorcycleDTO) {
		Motorcycle existingMotorcycle = motorcycleRepository.findByDomain(updatedMotorcycleDTO.getDomain())
				.orElseThrow(() -> new ResourceNotFoundException(DefaultValues.CLIENT_NOT_FOUND_BY_DNI, "domain",
						updatedMotorcycleDTO.getDomain()));

		utils.mapUpdatedMotorcycleDTOToEntity(updatedMotorcycleDTO, existingMotorcycle);
		existingMotorcycle = motorcycleRepository.save(existingMotorcycle);

		return utils.mapToMotorcycleDTO(existingMotorcycle);
	}
	
	
	@Override
	@Transactional
	public MotorcycleDTO updateMotorcycleByDomain(String domain, MotorcycleDTO updatedMotorcycleDTO) {
    	logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  pasado es = ", domain);
	    Motorcycle existingMotorcycle = motorcycleRepository.findByDomain(domain)
	            .orElseThrow(() -> new ResourceNotFoundException(DefaultValues.MOTOR_NOT_FOUND_BY_DOMAIN, "domain", domain));

	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setBrand, existingMotorcycle.getBrand(), updatedMotorcycleDTO.getBrand());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setDomain, existingMotorcycle.getDomain(), updatedMotorcycleDTO.getDomain());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setModel, existingMotorcycle.getModel(), updatedMotorcycleDTO.getModel());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setCylinder, existingMotorcycle.getCylinder(), updatedMotorcycleDTO.getCylinder());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setKilometers, existingMotorcycle.getKilometers(), updatedMotorcycleDTO.getKilometers());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setYear, existingMotorcycle.getYear(), updatedMotorcycleDTO.getYear());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setMotorNumber, existingMotorcycle.getMotorNumber(), updatedMotorcycleDTO.getMotorNumber());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setComment, existingMotorcycle.getComment(), updatedMotorcycleDTO.getComment());
	    utils.updateIfNotNullOrDifferent(existingMotorcycle::setChassis, existingMotorcycle.getChassis(), updatedMotorcycleDTO.getChassis());


	    existingMotorcycle = motorcycleRepository.save(existingMotorcycle);

	    return utils.mapToMotorcycleDTO(existingMotorcycle);
	}

}

	
//@Override
//public MotorcycleDTO updateMotorcycleByDomain(String domain) {
//	Motorcycle existingMotorcycle = motorcycleRepository.findByDomain(domain)
//			.orElseThrow(() -> new ResourceNotFoundException(DefaultValues.MOTOR_NOT_FOUND_BY_DOMAIN, "domain", domain));
//
//	utils.mapUpdatedMotorcycleDTOToEntity(updatedMotorcycleDTO, existingMotorcycle);
//	existingMotorcycle = motorcycleRepository.save(existingMotorcycle);
//
//	return utils.mapToMotorcycleDTO(existingMotorcycle);
//}


//
//	@Override
//	public MotorcycleDTO updateMotorcycle(MotorcycleDTO motorcycleDTO, Long motorcycleId) {
//		Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
//				.orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "motorcycleId", motorcycleId));
//		motorcycle.setBrand(motorcycleDTO.getBrand());
//		motorcycle.setDomain(motorcycleDTO.getDomain());
//		
//		Motorcycle motorcycleUpdated = motorcycleRepository.save(motorcycle);
//		return utils.mapToMotorcycleDTO(motorcycleUpdated);
//	}
//

