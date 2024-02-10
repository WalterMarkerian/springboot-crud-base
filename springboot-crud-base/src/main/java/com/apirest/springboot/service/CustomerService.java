package com.apirest.springboot.service;

import java.util.List;

import com.apirest.springboot.dto.CustomerDTO;

public interface CustomerService {
	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	public List<CustomerDTO> getAllCustomers();
//	public List<CustomerDTO> getAllrcMotoyclesByCustomer();
	public CustomerDTO getCustomerById(Long id);
	//	public CustomerDTO getCustomerByCustomer(String Customer);
	//	public CustomerDTO getCustomerByDomain(String domain);

	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);
	// 	public CustomerDTO updateCustomerByBrand(CustomerDTO customerDTO, Long id);

	public void deleteCustomerById(Long id);
//	public void deleteCustomeryBrand(Long id);
}