package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.MotorcycleDTO;

public interface MotorcycleService {
	public MotorcycleDTO createMotorcycle(MotorcycleDTO motorcycleDTO);
	public List<MotorcycleDTO> getAllMotorcycles();
//	public List<MotorcycleDTO> getAllMotorcyclesByClient();
	public MotorcycleDTO getMotorcycleById(Long id);
	//	public MotorcycleDTO getMotorcycleByClient(String Client);
	//	public MotorcycleDTO getMotorcycleByDomain(String domain);

	public MotorcycleDTO updateMotorcycle(MotorcycleDTO motorcycleDTO, Long id);
	// 	public MotorcycleDTO updateMotorcycleByBrand(MotorcycleDTO motorcycleDTO, Long id);

	public void deleteMotorcycleById(Long id);
//	public void deleteMotorcycleByBrand(Long id);
}
