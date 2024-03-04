package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;

public interface CustomerService {
	public List<CustomerDTO> getAllCustomers();

	public CustomerDTO getCustomerById(Long customerId);

	public CustomerDTO getCustomerByDni(String dni);

	public CustomerDTO createCustomerWhitMotorcycle(CustomerDTO customerDTO);

	public CustomerDTO createCustomerWithoutMotorcycle(CustomerDTO customerDTO);

	public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO);

	public CustomerDTO updateCustomerByDni(String dni, CustomerDTO updatedCustomerDTO);

	public CustomerDTO addMotorcycleToCustomer(String dni, MotorcycleDTO motorcycleDTO);

	public void deleteCustomerByCustomerDni(String dni);

}