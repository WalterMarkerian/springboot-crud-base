package com.apirest.springboot.entities;

import java.util.Collections;
import java.util.List;

import com.apirest.springboot.utils.Genders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "customerId" }) })
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
    @Column(name = "dni", nullable = false, unique = true)
	private String dni;
	@Column(name = "gender", nullable = false)
	private Genders gender;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "comment", nullable = true)
	private String comment;


	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Motorcycle> motorcycles;

	public List<Motorcycle> getMotorcycles() {
		return motorcycles != null ? motorcycles : Collections.emptyList();
	}

	public void setMotorcycles(List<Motorcycle> motorcycles) {
		this.motorcycles = motorcycles;
	}
	
    public void addMotorcycle(Motorcycle motorcycle) {
        motorcycles.add(motorcycle);
        motorcycle.setCustomer(this);
    }

}
