package com.apirest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.springboot.dto.CustomerDTO;
import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.service.CustomerService;


@RestController
@RequestMapping("/clientes")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<CustomerDTO> listCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{customerId}/motos")
	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(@PathVariable(value = "customerId") Long customerId){
		return customerService.getAllMotorcyclesByCustomerId(customerId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	
	@PostMapping("/cliente")
	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
		return new ResponseEntity<>(customerService.createCustomer(customerDTO),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable(name = "id") Long id){
		CustomerDTO customerResponse = customerService.updateCustomer(customerDTO, id);
		return new ResponseEntity<>(customerResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") Long id){
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>("Customer deleted successfully",HttpStatus.OK);
	}

}
