package com.apirest.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class SpringbootCrudBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudBaseApplication.class, args);
	}

}
