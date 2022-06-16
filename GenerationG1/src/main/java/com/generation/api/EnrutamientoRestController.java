package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class EnrutamientoRestController {
	

		/*
		 * //http://localhost:8080/
		 * 
		 * @RequestMapping("/usuario") public String usuario() { return null; }
		 */
		
		/** Enrutamientos */
		// http://localhost:9080/usuario
		@RequestMapping("/usuario") // Anotacion para capturar las rutas
		public String usuario() {

			return "estamos en la url usuario";

		}
		
		@RequestMapping("/usuario/inscrito") // Anotacion para capturar las rutas
		public String inscrito() {

			return "estamos en la url usuario/inscrito";

		}
		
		@RequestMapping("/cliente/registrado") // Anotacion para capturar las rutas
		public String cliente() {

			return "ruta de cliente";

		}
		
		@RequestMapping(value = "/proveedor/registrado", method= RequestMethod.GET)
		public String proveedor () {

			return "ruta del proveedor/registrado";

		}
		
		
		
		
	}


