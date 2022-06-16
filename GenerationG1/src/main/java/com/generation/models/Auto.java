package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Auto se convertira en entidad
@Entity
@Table(name = "autos")
public class Auto {
	// Atributos

	// Cuando se agrege un elemnto este tendra un id PK e ira aumentando
	// automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private String color;
	private String patente;

	// Constructores
	public Auto() {
		super();
	}

	public Auto(Long id, String marca, String modelo, String color, String patente) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.patente = patente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	// Getters and Setters

}
