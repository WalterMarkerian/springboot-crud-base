package com.apirest.springboot.service;

import java.util.List;
import java.util.Optional;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;

public interface MotorcycleService {
	public List<MotorcycleDTO> getAllMotorcycles();

	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId);

	public Optional<MotorcycleDTO> getMotorcycleByDomain(String domain);

	public void deleteMotorcycleByMotorcycleId(String domain);

	public MotorcycleDTO updateMotorcycle(MotorcycleDTO updatedMotorcycleDTO);

	public MotorcycleDTO updateMotorcycleByDomain(String domain, MotorcycleDTO updatedMotorcycleDTO);

}
