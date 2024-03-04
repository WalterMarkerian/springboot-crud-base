package com.apirest.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.entities.Motorcycle;
import com.apirest.springboot.exceptions.CustomerAlreadyExistsException;
import com.apirest.springboot.exceptions.ResourceNotFoundException;
import com.apirest.springboot.repository.CustomerRepository;
import com.apirest.springboot.repository.MotorcycleRepository;
import com.apirest.springboot.utils.Utils;
import com.apirest.springboot.utils.DefaultValues;

import jakarta.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Validated
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MotorcycleRepository motorcycleRepository;

	@Autowired
	private Utils utils;

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> utils.mapToCustomerDTO(customer)).collect(Collectors.toList());
	}
	
	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
		return utils.mapToCustomerDTO(customer);
	}

	@Override
	public CustomerDTO getCustomerByDni(String dni) {
		Customer customer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "dni", dni));
		return utils.mapToCustomerDTO(customer);
	}


	@Override
	@Transactional
	public CustomerDTO createCustomerWithoutMotorcycle(CustomerDTO customerDTO) {
		Customer customer = utils.mapToCustomerEntity(customerDTO);
		Customer newCustomer = customerRepository.save(customer);
		return utils.mapToCustomerDTO(newCustomer);
	}

	@Transactional
	public CustomerDTO createCustomerWhitMotorcycle(CustomerDTO customerDTO) {

		// Mapea el DTO del cliente a la entidad Customer
		Customer customer = utils.mapToCustomerEntity(customerDTO);

		// Mapea los DTO de motocicletas a entidades Motorcycle
		List<Motorcycle> motorcycles = customerDTO.getMotorcycles().stream()
				.map(motorcycleDTO -> utils.mapToMotorcycleEntity(motorcycleDTO)).collect(Collectors.toList());

		// Establece la relación entre Customer y Motorcycle
		for (Motorcycle motorcycle : motorcycles) {
			motorcycle.setCustomer(customer);
		}
		customer.setMotorcycles(motorcycles);
		Customer newCustomer = customerRepository.save(customer);
		motorcycleRepository.saveAll(motorcycles);

		return utils.mapToCustomerDTO(newCustomer);
	}

	@Override
	@Transactional
	public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO) {
		Customer existingCustomer = customerRepository.findByDni(updatedCustomerDTO.getDni())
				.orElseThrow(() -> new ResourceNotFoundException(DefaultValues.CLIENT_NOT_FOUND_BY_DNI, "dni",
						updatedCustomerDTO.getCustomerId()));

		utils.mapUpdatedCustomerDTOToEntity(updatedCustomerDTO, existingCustomer);
		existingCustomer = customerRepository.save(existingCustomer);

		return utils.mapToCustomerDTO(existingCustomer);
	}
	
	@Override
	@Transactional
	public CustomerDTO updateCustomerByDni(String dni, CustomerDTO updatedCustomerDTO) {
		Customer existingCustomer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException(DefaultValues.CLIENT_NOT_FOUND_BY_DNI, "dni",
						updatedCustomerDTO.getCustomerId()));
		utils.updateIfNotNullOrDifferent(existingCustomer::setName, existingCustomer.getName(),
				updatedCustomerDTO.getName());
		utils.updateIfNotNullOrDifferent(existingCustomer::setSurname, existingCustomer.getSurname(),
				updatedCustomerDTO.getSurname());
		utils.updateIfNotNullOrDifferent(existingCustomer::setPhone, existingCustomer.getPhone(),
				updatedCustomerDTO.getPhone());
		utils.updateIfNotNullOrDifferent(existingCustomer::setEmail, existingCustomer.getPhone(),
				updatedCustomerDTO.getPhone());
		utils.updateIfNotNullOrDifferent(existingCustomer::setGender, existingCustomer.getGender(),
				updatedCustomerDTO.getGender());
		utils.updateIfNotNullOrDifferent(existingCustomer::setComment, existingCustomer.getComment(),
				updatedCustomerDTO.getComment());
		

		existingCustomer = customerRepository.save(existingCustomer);

		return utils.mapToCustomerDTO(existingCustomer);
	}

	@Override
	@Transactional
	public CustomerDTO addMotorcycleToCustomer(String dni, MotorcycleDTO motorcycleDTO) {
		Customer existingCustomer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "dni", dni));

		Motorcycle motorcycleEntity = utils.mapToMotorcycleEntity(motorcycleDTO);
		existingCustomer.addMotorcycle(motorcycleEntity);
		Customer updatedCustomer = customerRepository.save(existingCustomer);
		return utils.mapToCustomerDTO(updatedCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomerByCustomerDni(String dni) {
		Customer customer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "dni", dni));
		customerRepository.delete(customer);
	}

	
}
