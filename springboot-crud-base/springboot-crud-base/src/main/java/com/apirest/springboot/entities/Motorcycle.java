package com.apirest.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
@Data
@Entity
@Table(name ="MOTORCYCLES", uniqueConstraints= {@UniqueConstraint(columnNames = {"domain"})})
public class Motorcycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long motorcycleId;
	@Column(name = "domain", nullable = false)
	private String domain;
	@Column(name = "brand", nullable = false)
	private String brand;
	@Column(name = "model", nullable = false)
	private String model;
	@Column(name = "cylinder", nullable = false)
	private String cylinder;
	@Column(name = "year", nullable = false)
	private String year;
	@Column(name = "chassis", nullable = false)
	private String chassis;
	@Column(name = "motorNumber", nullable = false)
	private String motorNumber;
	@Column(name = "kilometers", nullable = false)
	private String kilometers;
	@Column(name = "comment", nullable = true)
	private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    

}
