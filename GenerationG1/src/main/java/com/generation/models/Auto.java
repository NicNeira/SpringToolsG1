package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	
	//opcionales, sirven para la gestion de la base dato
	@Column(updatable = false)//esta columna especifica nunca se va a actualizar atravez del sistema
	private Date createdAt;//Para saber en que momento fue insertada en la base de datos
	private Date updatedAt;//Para cuando se actualizo

	// Constructores
	
	//constructor vacio
	public Auto() {
		super();
	}

	//Constructor con parametros
	public Auto(Long id, String marca, String modelo, String color, String patente) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.patente = patente;
	}

	//Getter and Setters
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

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    

}
