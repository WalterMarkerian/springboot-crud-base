package com.apirest.springboot.entities;

import java.util.List;

import com.apirest.springboot.utils.Genders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Entity
@Table(name ="customers", uniqueConstraints= {@UniqueConstraint(columnNames = {"id"})})
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "gender", nullable = false)
	private Genders gender;
	@Column(name = "comment", nullable = false)
	private String comment;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "motorcycle_id", nullable = false)
//	private Motorcycle motorcycle;
//	
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Motorcycle> motorcycles;
	
}
