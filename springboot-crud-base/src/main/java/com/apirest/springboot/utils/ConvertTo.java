package com.apirest.springboot.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.entities.Motorcycle;


@Component
public class ConvertTo {
		
	public CustomerDTO mapToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setGender(customer.getGender());
        customerDTO.setComment(customer.getComment());

        List<MotorcycleDTO> motorcycleDTOs = customer.getMotorcycles()
                .stream()
                .map(this::mapToMotorcycleDTO)
                .collect(Collectors.toList());

        customerDTO.setMotorcycles(motorcycleDTOs);

        return customerDTO;
    }
	
	
	public Customer mapToCustomerEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setName(customerDTO.getName());
		customer.setSurname(customerDTO.getSurname());
		customer.setPhone(customerDTO.getPhone());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setComment(customerDTO.getComment());
		
		 List<Motorcycle> motorcycle = customerDTO.getMotorcycles()
	                .stream()
	                .map(this::mapToMotorcycleEntity)
	                .collect(Collectors.toList());

	        customer.setMotorcycles(motorcycle);

		
		return customer;

	}
	
    public List<CustomerDTO> mapToDTOList(List<Customer> customers) {
        return customers.stream().map(this::mapToCustomerDTO).collect(Collectors.toList());
    }

	
	public MotorcycleDTO mapToMotorcycleDTO(Motorcycle motorcycle) {
		MotorcycleDTO motorcycleDTO = new MotorcycleDTO();
		motorcycleDTO.setMotorcycleId(motorcycle.getMotorcycleId());
		motorcycleDTO.setBrand(motorcycle.getBrand());
		motorcycleDTO.setDomain(motorcycle.getDomain());
		motorcycleDTO.setModel(motorcycle.getModel());
		motorcycleDTO.setCylinder(motorcycle.getCylinder());
		motorcycleDTO.setYear(motorcycle.getYear());
		motorcycleDTO.setKilometers(motorcycle.getKilometers());
		motorcycleDTO.setComment(motorcycle.getComment());
		motorcycleDTO.setChassis(motorcycle.getChassis());
		motorcycleDTO.setMotorNumber(motorcycle.getMotorNumber());
	
		return motorcycleDTO;
	}
	
	public Motorcycle mapToMotorcycleEntity(MotorcycleDTO motorcycleDTO) {
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.setMotorcycleId(motorcycleDTO.getMotorcycleId());
		motorcycle.setBrand(motorcycleDTO.getBrand());
		motorcycle.setDomain(motorcycleDTO.getDomain());
		motorcycle.setModel(motorcycleDTO.getModel());
		motorcycle.setCylinder(motorcycleDTO.getCylinder());
		motorcycle.setYear(motorcycleDTO.getYear());
		motorcycle.setKilometers(motorcycleDTO.getKilometers());
		motorcycle.setComment(motorcycleDTO.getComment());
		motorcycle.setChassis(motorcycleDTO.getChassis());
		motorcycle.setMotorNumber(motorcycleDTO.getMotorNumber());
		return motorcycle;
	}
	

}
