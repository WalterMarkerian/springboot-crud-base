package com.apirest.springboot.controller;

import java.util.List;
import java.util.UUID;

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

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.service.MotorcycleService;

@RestController
@RequestMapping("/motos")
public class MotorcycleController {
	
	@Autowired
	private MotorcycleService motorcycleService;
	
	@GetMapping
	public List<MotorcycleDTO> listMotorcycles(){
		return motorcycleService.getAllMotorcycles();
	}
	
	@GetMapping("/cliente/{customerId}")
	public ResponseEntity<List<MotorcycleDTO>> getAllMotorcyclesByCustomerId(@PathVariable Long customerId) {
        List<MotorcycleDTO> motorcycles = motorcycleService.getAllMotorcyclesByCustomerId(customerId);
        return ResponseEntity.ok(motorcycles);
    }
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<MotorcycleDTO> getMotorcycleByUUID(@PathVariable(name = "id") UUID uuid){
//		return ResponseEntity.ok(motorcycleService.getMotorcycleByMotorcycleUUID(uuid));
//	}
//	
//	@GetMapping("/domain/{domain}")
//	public ResponseEntity<MotorcycleDTO> getMotorcycleByDomain(@PathVariable(name = "domain") String domain){
//		return ResponseEntity.ok(motorcycleService.getMotorcycleByDomain(domain));
//	}
//	
//	
//	@PostMapping("/moto")
//	public ResponseEntity<MotorcycleDTO> saveMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO){
//		return new ResponseEntity<>(motorcycleService.createMotorcycle(motorcycleDTO),HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<MotorcycleDTO> updateMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO, @PathVariable(name = "uuid") UUID uuid){
//		MotorcycleDTO motorcycleResponse = motorcycleService.updateMotorcycle(motorcycleDTO, uuid);
//		return new ResponseEntity<>(motorcycleResponse,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteMotorcycle(@PathVariable(name = "id") UUID uuid){
//		motorcycleService.deleteMotorcycleByMotorcycleUUID(uuid);
//		return new ResponseEntity<>("Motorcycle deleted successfully",HttpStatus.OK);
//	}

	
}
