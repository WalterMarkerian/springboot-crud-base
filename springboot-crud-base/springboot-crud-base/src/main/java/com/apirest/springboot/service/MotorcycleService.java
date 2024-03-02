package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.MotorcycleDTO;

public interface MotorcycleService {
	public List<MotorcycleDTO> getAllMotorcycles();
	
//	public MotorcycleDTO createMotorcycle(MotorcycleDTO motorcycleDTO);
	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId);
//	public MotorcycleDTO updateMotorcycle(MotorcycleDTO motorcycleDTO, Long motorcycleId);
//	public void deleteMotorcycleByMotorcycleId(Long motorcycleId);
//	public MotorcycleDTO getMotorcycleByMotorcycleId(Long motorcycleId);
//	public MotorcycleDTO getMotorcycleByClient(String Client);
//	public MotorcycleDTO getMotorcycleByDomain(String domain);
// 	public MotorcycleDTO updateMotorcycleByBrand(MotorcycleDTO motorcycleDTO, Long id);
//	public void deleteMotorcycleByBrand(Long id);
//	public MotorcycleDTO getMotorcycleByDomain(String domain);
//	public List<MotorcycleDTO> getAllMotorcyclesByCustomerID(Long customerId);
}
