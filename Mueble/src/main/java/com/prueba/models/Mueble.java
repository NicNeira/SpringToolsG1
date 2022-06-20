//Creacion de objeto mueble

package com.prueba.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="muebles")
public class Mueble {
	//Atributos
	
	// Cuando se agrege un elemento este tendra un id PK e ira aumentando automaticamente
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String tipoMueble;
		private String tipoMadera;
		private String color;
		
		//Constructores
		public Mueble() {
			super();
		}
		
		//Getters and Setters
		public Mueble(Long id, String tipoMueble, String tipoMadera, String color) {
			super();
			this.id = id;
			this.tipoMueble = tipoMueble;
			this.tipoMadera = tipoMadera;
			this.color = color;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipoMueble() {
			return tipoMueble;
		}

		public void setTipoMueble(String tipoMueble) {
			this.tipoMueble = tipoMueble;
		}

		public String getTipoMadera() {
			return tipoMadera;
		}

		public void setTipoMadera(String tipoMadera) {
			this.tipoMadera = tipoMadera;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		
		
		
}
