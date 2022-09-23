package com.zoologico.api.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "animales", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Animales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "especie")
	private String especie;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "peso")
	private double peso;
	
	@Column(name = "altura")
	private double altura;
	
	@Column(name = "estado")
	private String estado;

	public Animales() {
		super();
	}
	
}
