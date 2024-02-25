package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;

public interface CustomerService {
	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	public List<CustomerDTO> getAllCustomers();
	public List<CustomerDTO> getAllMotoyclesByCustomer();
	public CustomerDTO getCustomerById(Long id);
	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long id);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);

	public void deleteCustomerById(Long id);
}