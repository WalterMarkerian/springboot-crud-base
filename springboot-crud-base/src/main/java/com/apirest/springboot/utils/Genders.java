package com.apirest.springboot.utils;

public enum Genders {

	MALE ("Male"), 
	FEMALE ("Female"), 
	UNDEFINED ("Undefined");
	
	private final String name;

	Genders(String name){
		this.name = name;
	}
	
}
