package com.apirest.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name ="motos", uniqueConstraints= {@UniqueConstraint(columnNames = {"domain"})})
@Data
public class Motorcycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "domain", nullable = false)
	private String domain;
	@Column(name = "brand", nullable = false)
	private String brand;
//	@Column(name = "model", nullable = false)
//	private String model;
//	@Column(name = "cylinder", nullable = false)
//	private String cylinder;
//	@Column(name = "year", nullable = false)
//	private String year;
//	@Column(name = "kilometers", nullable = false)
//	private String kilometers;
	
}
