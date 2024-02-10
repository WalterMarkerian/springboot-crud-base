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
@Table(name ="motorcycles", uniqueConstraints= {@UniqueConstraint(columnNames = {"domain"})})
@Data
public class Motorcycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "domain", nullable = false)
	private String domain;
	@Column(name = "brand", nullable = false)
	private String brand;
	@Column(name = "kilometers", nullable = false)
	private String kilometers;
	@Column(name = "chassis", nullable = false)
	private String chassis;
	@Column(name = "motorNumber", nullable = false)
	private String motorNumber;
	@Column(name = "model", nullable = true)
	private String model;
	@Column(name = "cylinder", nullable = true)
	private String cylinder;
	@Column(name = "year", nullable = true)
	private String year;
	@Column(name = "comment", nullable = true)
	private String comment;
	
	

	
}
