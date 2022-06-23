package com.generation.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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

	// opcionales, sirven para la gestion de la base dato
	@Column(updatable = false) // esta columna especifica nunca se va a actualizar atravez del sistema
	private Date createdAt;// Para saber en que momento fue insertada en la base de datos
	private Date updatedAt;// Para cuando se actualizo

	// Relaciones OneToOne (1a1)
	// / restringir o mantener la integridad de la data /
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	// Eager carga automaticamente / lazy cuando cargamos los datos
	private Licencia licencia;

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

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	/*
	 * @Override public String toString() { return "Nombre: " + nombre + " " +
	 * apellido + " Edad: " + edad + " La password es: " + password; }
	 */

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
