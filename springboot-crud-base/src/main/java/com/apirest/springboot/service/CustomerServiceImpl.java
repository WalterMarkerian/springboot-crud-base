package com.apirest.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.CustomerRepository;
import com.apirest.springboot.utils.ConvertCustomer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ConvertCustomer convertCustomer;
	

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO){
			Customer customer = convertCustomer.toEntity(customerDTO);
			Customer newCustomer = customerRepository.save(customer);
			CustomerDTO customerResponse = convertCustomer.toDTO(newCustomer);
		return customerResponse;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> convertCustomer.toDTO(customer))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		return convertCustomer.toDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		customer.setName(customerDTO.getName());
		customer.setSurname(customerDTO.getSurname());
		customer.setPhone(customerDTO.getPhone());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setComment(customerDTO.getComment());
		
		Customer customerUpdated = customerRepository.save(customer);
		return convertCustomer.toDTO(customerUpdated);
	}

	@Override
	public void deleteCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		customerRepository.delete(customer);
	}


}
