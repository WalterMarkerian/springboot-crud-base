package com.apirest.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.service.CustomerService;
import com.apirest.springboot.service.CustomerServiceImpl;
import com.apirest.springboot.utils.Utils;
import com.apirest.springboot.utils.DefaultValues;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("/clientes")
@Validated
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Utils utils;
	
    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    
	@GetMapping
	public List<CustomerDTO> listCustomers(){
		return customerService.getAllCustomers();
	}
	
    @GetMapping("/porCliente")
    public ResponseEntity<CustomerDTO> getCustomerById(@Valid @RequestParam Long customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("/porDni")
    public ResponseEntity<CustomerDTO> getCustomerByDni(@Valid @RequestParam String dni) {
        CustomerDTO customer = customerService.getCustomerByDni(dni);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO updatedCustomerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(updatedCustomerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @PostMapping("/crearClienteConMoto")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomerWhitMotorcycle(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
    
	@PutMapping("/agregarMoto")
    public ResponseEntity<CustomerDTO> addMotorcycleToCustomer(
            @RequestParam String dni,
            @Valid @RequestBody MotorcycleDTO motorcycleDTO) {
        CustomerDTO updatedCustomer = customerService.addMotorcycleToCustomer(dni, motorcycleDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    
	@DeleteMapping("/borrarCliente")
	public ResponseEntity<String> deleteCustomer(@RequestParam String dni){
		customerService.deleteCustomerByCustomerDni(dni);
		return new ResponseEntity<>(DefaultValues.CLIENT_DELETED_OK,HttpStatus.OK);
	}
	
    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomerByDni(
            @RequestParam String dni,
            @RequestBody CustomerDTO updatedCustomerDTO) {

    	CustomerDTO updatedCustomer = customerService.updateCustomerByDni(dni, updatedCustomerDTO);
        
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
	
}
