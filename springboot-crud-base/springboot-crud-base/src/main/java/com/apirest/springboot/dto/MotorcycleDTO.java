package com.apirest.springboot.dto;


import javax.validation.constraints.*;

import lombok.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Length;

import com.apirest.springboot.service.CustomerServiceImpl;
import com.apirest.springboot.utils.DefaultValues;

@Data
public class MotorcycleDTO {
	private Long motorcycleId;
	@NotEmpty(message= DefaultValues.DOMAIN_NOT_BLANK)
	@Pattern(regexp = "^.{6,8}$", message = "La longitud de la patente no cumple con los requisitos")
	private String domain;
	private String brand;
	private String model;
	private String cylinder;
	@NotEmpty(message= DefaultValues.YEAR_NOT_BLANK)
	@Min(value = 1900, message = "Año de fabricación no válido")
	@Max(value = 2100, message = "Año de fabricación no válido")
	private String year;
	@NotEmpty(message= DefaultValues.CHASSIS_NOT_BLANK)
    @Length(min = 17, max = 17, message = DefaultValues.CHASSIS_LENGTH)
	private String chassis;
	@NotEmpty(message= DefaultValues.MOTORNUMBER_NOT_BLANK)
	private String motorNumber;
	@Min(value = 0, message = DefaultValues.NOT_NEGATIVE_KM)
	private String kilometers;	
	private String comment;
	
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
    @AssertTrue(message = "La longitud de la patente no cumple con los requisitos")
    public boolean isLicensePlateValid() {
        logger.debug("Validando la longitud de la patente...");

        try {
            int requiredLength = determineRequiredLength(Integer.parseInt(year));
            int domainLength = domain != null ? domain.length() : 0;

            if (domainLength != requiredLength) {
                throw new IllegalArgumentException(DefaultValues.DOMAIN_LENGTH_FAIL);
            }

            return true;
        } catch (Exception e) {
        	logger.error("Error al validar la longitud de la patente", e);

            throw new IllegalStateException("Error al validar la longitud de la patente", e);
        }
    }

    public static int determineRequiredLength(int fabricationYear) {
        try {
            // Lógica para determinar la longitud requerida según el año de fabricación
        	// MAYOR O IGUAL QUE 2016 LLEVA 7 CARACETERES
        	// ENTRE 1994 (INCLUSIVE) Y 2016 LLEVA 6 CARACTERES
        	// MENOR A 1994 LLEVA 8
            if (fabricationYear >= 2016) {
                return 7;  
            } else if (fabricationYear >= 1994 && fabricationYear < 2016) {
                return 6;  
            } else {
                return 8;  
            }
        } catch (Exception e) {
            // Loggear la excepción si es necesario
        	logger.error("Error al determinar la longitud requerida", e);

            throw new IllegalStateException("Error al determinar la longitud requerida", e);
        }
    }
}