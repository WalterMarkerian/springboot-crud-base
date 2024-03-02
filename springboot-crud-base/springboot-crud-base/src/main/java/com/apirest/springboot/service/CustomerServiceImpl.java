package com.apirest.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.CustomerRepository;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.ConvertTo;

import jakarta.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MotorcycleRepository motorcycleRepository;

	@Autowired
	private ConvertTo convertTo;

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);


	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
		return convertTo.mapToCustomerDTO(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> convertTo.mapToCustomerDTO(customer)).collect(Collectors.toList());
	}

//	@Override
//	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
//		Customer customer = convertTo.mapToCustomerEntity(customerDTO);
//		Customer newCustomer = customerRepository.save(customer);
//		return convertTo.mapToCustomerDTO(newCustomer);
//	}

	@Transactional
	public CustomerDTO createCustomerWhitMotorcycle(CustomerDTO customerDTO) {
		// Mapea el DTO del cliente a la entidad Customer
		Customer customer = convertTo.mapToCustomerEntity(customerDTO);

		// Mapea los DTO de motocicletas a entidades Motorcycle
		List<Motorcycle> motorcycles = customerDTO.getMotorcycles().stream()
				.map(motorcycleDTO -> convertTo.mapToMotorcycleEntity(motorcycleDTO)).collect(Collectors.toList());

		// Establece la relación entre Customer y Motorcycle
		for (Motorcycle motorcycle : motorcycles) {
			motorcycle.setCustomer(customer);
		}
		// Asigna la lista de motorcycles al customer
		customer.setMotorcycles(motorcycles);

		// Guarda el customer y sus motorcycles en la base de datos
		Customer savedCustomer = customerRepository.save(customer);

		// Puedes guardar también los motorcycles si lo necesitas
		// motorcycleRepository.saveAll(motorcycles);

		// Mapea la entidad Customer nuevamente a un DTO para devolverlo
		return convertTo.mapToCustomerDTO(savedCustomer);
	}

	@Override
    public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO) {
        Customer existingCustomer = customerRepository.findById(updatedCustomerDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el cliente con ID: ", "customerId", updatedCustomerDTO.getCustomerId()));

        convertTo.mapUpdatedCustomerDTOToEntity(updatedCustomerDTO, existingCustomer);
        existingCustomer = customerRepository.save(existingCustomer);

        return convertTo.mapToCustomerDTO(existingCustomer);
    }


	
	
	
	
	
//
//
//	

//
//	@Override
//	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId) {
//		Customer customer = customerRepository.findById(customerId)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
//		customer.setName(customerDTO.getName());
//		customer.setSurname(customerDTO.getSurname());
//		customer.setPhone(customerDTO.getPhone());
//		customer.setEmail(customerDTO.getEmail());
//		customer.setGender(customerDTO.getGender());
//		customer.setComment(customerDTO.getComment());
//		
//		Customer customerUpdated = customerRepository.save(customer);
//		return converterTo.mapToCustomerDTO(customerUpdated);
//	}
//
//	@Override
//	public void deleteCustomerByCustomerId(Long customerId) {
//		Customer customer = customerRepository.findById(customerId)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
//		customerRepository.delete(customer);
//	}
//
//	@Override
//	public List<CustomerDTO> getAllMotoyclesByCustomer() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(Long customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<CustomerDTO> getAllCustomersWithMotorcycles() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
