package com.zoologico.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalesDTO {

	private Long id;
	
	private String nombre;
	
	private String especie;
	
	private int edad;
	
	private double peso;
	
	private double altura;
	
	private String estado;

}
