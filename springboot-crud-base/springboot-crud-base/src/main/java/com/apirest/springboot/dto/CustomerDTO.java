package com.apirest.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import com.apirest.springboot.utils.Genders;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "motorcycles")
public class CustomerDTO {
	private Long customerId;
	private String name;
	private String surname;
	private String dni;
	private Genders gender;
	private String phone;
	private String email;
	private String comment;

    private List<MotorcycleDTO> motorcycles = new ArrayList<>();

	    // constructor, getters y setters para otras propiedades

	public List<MotorcycleDTO> getMotorcycles() {
		return motorcycles;
	}

	public void setMotorcycles(List<MotorcycleDTO> motorcycles) {
		if (motorcycles != null) {
			this.motorcycles = motorcycles;
		}
	}

}
