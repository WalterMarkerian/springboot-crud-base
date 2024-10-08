package com.apirest.springboot.dto;


import lombok.Data;

@Data
public class MotorcycleDTO {
	private Long motorcycleId;
	private String domain;
	private String brand;
	private String model;
	private String cylinder;
	private String year;
	private String kilometers;
	private String comment;
	private String chassis;
	private String motorNumber;

}
