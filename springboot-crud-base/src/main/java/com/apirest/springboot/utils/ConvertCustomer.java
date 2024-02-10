package com.apirest.springboot.utils;

import org.springframework.stereotype.Component;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.entities.Customer;


@Component
public class ConvertCustomer {
	
	public CustomerDTO toDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setName(customer.getName());
		customerDTO.setSurname(customer.getSurname());
		customerDTO.setPhone(customer.getPhone());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setGender(customer.getGender());
		customerDTO.setComment(customer.getComment());
		return customerDTO;
	}
	
	public Customer toEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setName(customerDTO.getName());
		customer.setSurname(customerDTO.getSurname());
		customer.setPhone(customerDTO.getPhone());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setComment(customerDTO.getComment());
		return customer;

	}
}
