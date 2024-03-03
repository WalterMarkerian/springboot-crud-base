package com.apirest.springboot.utils;

import lombok.Data;

@Data
public class DefaultValues {
	public static final String CLIENT_NOT_FOUND ="No se encontró el cliente con ID: ";
	public static final String DOMAIN_NOT_BLANK = "El valor de DOMINIO no puede estar en blanco.";
	public static final String DOMAIN_LENGTH_FAIL = "La longitud del dominio no cumple con los requisitos.";
	public static final String CHASSIS_NOT_BLANK = "El valor de CHASSIS puede estar en blanco.";
	public static final String MOTORNUMBER_NOT_BLANK = "El valor de MOTORNUMBER no puede estar en blanco.";
	public static final String CHASSIS_LENGTH = "La longitud del numero de CHASSIS es incorrecto.";
	public static final String YEAR_NOT_BLANK = "El valor de YEAR no puede estar en blanco.";
	public static final String NOT_NEGATIVE_KM = "Los kilometros no pueden ser menores a 0.";

}
