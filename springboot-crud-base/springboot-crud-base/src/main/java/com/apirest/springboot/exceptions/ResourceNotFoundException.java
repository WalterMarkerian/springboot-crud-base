package com.apirest.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@Data
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String resourceField;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String resourceField, Object fieldValue) {
		super(String.format("%s no encontrado con : %s : '%s'",resourceName,resourceField,fieldValue));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.fieldValue = fieldValue;
	}
}
