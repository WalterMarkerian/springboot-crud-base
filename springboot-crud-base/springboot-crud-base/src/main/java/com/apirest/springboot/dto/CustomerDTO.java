package com.apirest.springboot.dto;

import java.util.List;

import com.apirest.springboot.utils.Genders;

import lombok.Data;
@Data
public class CustomerDTO {
	private Long customerId;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private Genders gender;
	private String comment;
	
    private List<MotorcycleDTO> motorcycles;

    
    

}
