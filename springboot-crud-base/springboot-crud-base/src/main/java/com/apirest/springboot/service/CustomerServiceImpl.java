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
import com.apirest.springboot.utils.ConvertTo;
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
	private ConvertTo convertTo;

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
		return convertTo.mapToCustomerDTO(customer);
	}
	
	@Override
	public CustomerDTO findByDni(String dni) {
		Customer customer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "dni", dni));
		return convertTo.mapToCustomerDTO(customer);
	}
	
	@Override
	public CustomerDTO getCustomerByDni(String dni) {
		Customer customer = customerRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "dni", dni));
		return convertTo.mapToCustomerDTO(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> convertTo.mapToCustomerDTO(customer)).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO createCustomerWithoutMotorcycle(CustomerDTO customerDTO) {
		Customer customer = convertTo.mapToCustomerEntity(customerDTO);
		Customer newCustomer = customerRepository.save(customer);
		return convertTo.mapToCustomerDTO(newCustomer);
	}

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
		Customer newCustomer = customerRepository.save(customer);

		// Puedes guardar también los motorcycles si lo necesitas
		// motorcycleRepository.saveAll(motorcycles);

		// Mapea la entidad Customer nuevamente a un DTO para devolverlo
		return convertTo.mapToCustomerDTO(newCustomer);
	}

//	@Override
//    public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO) {
//        Customer existingCustomer = customerRepository.findById(updatedCustomerDTO.getCustomerId())
//                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el cliente con ID: ", "customerId", updatedCustomerDTO.getCustomerId()));
//
//        convertTo.mapUpdatedCustomerDTOToEntity(updatedCustomerDTO, existingCustomer);
//        existingCustomer = customerRepository.save(existingCustomer);
//
//        return convertTo.mapToCustomerDTO(existingCustomer);
//    }

	@Override
	public CustomerDTO updateCustomer(CustomerDTO updatedCustomerDTO) {
		Customer existingCustomer = customerRepository.findById(updatedCustomerDTO.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException(DefaultValues.CLIENT_NOT_FOUND, "customerId",
						updatedCustomerDTO.getCustomerId()));

		// Mapear propiedades simples
		convertTo.mapUpdatedCustomerDTOToEntity(updatedCustomerDTO, existingCustomer);

		// Manejar la lista de motocicletas
		List<Motorcycle> existingMotorcycles = existingCustomer.getMotorcycles();
		List<MotorcycleDTO> updatedMotorcyclesDTO = updatedCustomerDTO.getMotorcycles();

		// Verificar si existen motocicletas en la lista actual y en la lista
		// actualizada
		if (existingMotorcycles != null && updatedMotorcyclesDTO != null) {
			// Mapear las motocicletas existentes y agregar las nuevas
			List<Motorcycle> updatedMotorcycles = updatedMotorcyclesDTO.stream()
					.map(motorcycleDTO -> convertTo.mapToMotorcycleEntity(motorcycleDTO)).collect(Collectors.toList());
			existingMotorcycles.addAll(updatedMotorcycles);
		} else if (updatedMotorcyclesDTO != null) {
			// Si no hay motocicletas existentes, simplemente mapear las motocicletas
			// actualizadas
			existingCustomer.setMotorcycles(updatedMotorcyclesDTO.stream()
			        .map(convertTo::mapToMotorcycleEntity)
			        .collect(Collectors.toList()));
		}

		// Guardar el cliente actualizado en el repositorio
		existingCustomer = customerRepository.save(existingCustomer);

		return convertTo.mapToCustomerDTO(existingCustomer);
	}

	@Override
	public CustomerDTO addMotorcycleToCustomer(Long customerId, MotorcycleDTO motorcycleDTO) {
		Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));

        // Mapear la MotorcycleDTO a una entidad Motorcycle y agregarla al cliente
        Motorcycle motorcycleEntity = convertTo.mapToMotorcycleEntity(motorcycleDTO);
        existingCustomer.addMotorcycle(motorcycleEntity);

        // Guardar el cliente actualizado en la base de datos
        Customer updatedCustomer = customerRepository.save(existingCustomer);

        // Mapear el cliente actualizado a un DTO y devolverlo
        return convertTo.mapToCustomerDTO(updatedCustomer);
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
