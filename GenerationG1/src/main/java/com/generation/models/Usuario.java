package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Usuario se convertira en entidad
@Entity
@Table(name = "usuarios")
public class Usuario {

	// Atributos
	@Id
	// Cuando se agrege un elemento este tendra un id primary key e ira aumentando
	// automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 20) // Limita la cantidad de caracteres
	private String nombre;
	@Size(min = 3, max = 20)
	private String apellido;

	private Integer edad;

	@NotNull // Para que no sea nulo el campo password
	@Size(min = 6, max = 8)
	private String password;

	// Constructores
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, Integer edad, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.password = password;
	}
	

	// Geter and setters
	

	public String getNombre() {
		return nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * @Override public String toString() { return "Nombre: " + nombre + " " +
	 * apellido + " Edad: " + edad + " La password es: " + password; }
	 */

}
