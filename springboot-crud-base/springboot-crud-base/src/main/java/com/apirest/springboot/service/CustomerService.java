package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;

public interface CustomerService {
	public List<CustomerDTO> getAllCustomers();
//	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	public CustomerDTO createCustomerWhitMotorcycle(CustomerDTO customerDTO);
	public CustomerDTO getCustomerById(Long customerId);
	public CustomerDTO getCustomerByDni(String dni);
	public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO);
	public CustomerDTO createCustomerWithoutMotorcycle(CustomerDTO customerDTO);
	public CustomerDTO addMotorcycleToCustomer(Long customerId, MotorcycleDTO motorcycleDTO);
	public CustomerDTO findByDni(String dni);
	
//	public List<CustomerDTO> getAllMotoyclesByCustomer();
//	public CustomerDTO getCustomerById(Long customerId);
//	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId);
//	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId);
//	public void deleteCustomerByCustomerId(Long customerId);
//	public List<CustomerDTO> getAllCustomersWithMotorcycles();
//	
	
}