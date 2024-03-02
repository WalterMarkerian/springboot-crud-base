package com.apirest.springboot.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
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
import com.apirest.springboot.entities.Customer;
import com.apirest.springboot.service.CustomerService;
import com.apirest.springboot.service.CustomerServiceImpl;
import com.apirest.springboot.utils.ConvertTo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("/clientes")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ConvertTo convertTo;

	
    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    
	@GetMapping
	public List<CustomerDTO> listCustomers(){
		return customerService.getAllCustomers();
	}

//	@PostMapping("/crear")
//	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
//		Customer customer = convertTo.mapToCustomerEntity(customerDTO);
////		Motorcycle motorcycle = converterTo.mapToMotorcycleEntity(motorcycleDTO);
////		logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!CustomerController: " + customer);
//		return new ResponseEntity<>(customerService.createCustomer(customerDTO),HttpStatus.CREATED);
//	}
	
    @PostMapping("/crearClienteConMoto")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
	
	
	
//	@PostMapping("/crear")
//	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO, MotorcycleDTO motorcycleDTO){
//		return new ResponseEntity<>(customerService.createCustomer(customerDTO, motorcycleDTO),HttpStatus.CREATED);
//	}
	
//    @GetMapping("/motos")
//    public List<CustomerDTO> getAllCustomersWithMotorcycles() {
//        return customerService.getAllCustomersWithMotorcycles();
//    }
//	
//	@GetMapping("/{customerId}/motos")
//	public List<MotorcycleDTO> getAllMotorcyclesByCustomerId(@PathVariable(value = "customerId") Long customerId){
//		return customerService.getAllMotorcyclesByCustomerId(customerId);
//	}
//	
//	@GetMapping("/{customerId}")
//	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "customerId") Long customerId){
//		return ResponseEntity.ok(customerService.getCustomerById(customerId));
//	}
//	
//	

//	
//	@PutMapping("/{customerId}")
//	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable(name = "customerId") Long customerId){
//		CustomerDTO customerResponse = customerService.updateCustomer(customerDTO, customerId);
//		return new ResponseEntity<>(customerResponse,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteCustomer(@PathVariable(name = "customerId") Long customerId){
//		customerService.deleteCustomerByCustomerId(customerId);
//		return new ResponseEntity<>("Customer deleted successfully",HttpStatus.OK);
//	}

}
