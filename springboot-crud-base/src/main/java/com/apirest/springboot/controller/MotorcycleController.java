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

import com.apirest.springboot.dto.MotorcycleDTO;
import com.apirest.springboot.service.MotorcycleService;

@RestController
@RequestMapping("/motos")
public class MotorcycleController {
	
	@Autowired
	private MotorcycleService motorcycleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MotorcycleDTO> getMotorcycleById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(motorcycleService.getMotorcycleById(id));
	}
	
	@GetMapping
	public List<MotorcycleDTO> listMotorcycles(){
		return motorcycleService.getAllMotorcycles();
	}
	
	@PostMapping
	public ResponseEntity<MotorcycleDTO> saveMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO){
		return new ResponseEntity<>(motorcycleService.createMotorcycle(motorcycleDTO),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MotorcycleDTO> updateMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO, @PathVariable(name = "id") Long id){
		MotorcycleDTO motorcycleResponse = motorcycleService.updateMotorcycle(motorcycleDTO, id);
		return new ResponseEntity<>(motorcycleResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMotorcycle(@PathVariable(name = "id") Long id){
		motorcycleService.deleteMotorcycleById(id);
		return new ResponseEntity<>("Motorcycle deleted successfully",HttpStatus.OK);
	}

	
}
