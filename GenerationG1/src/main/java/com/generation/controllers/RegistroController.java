package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro") // asiganamos por default /registro
public class RegistroController {

	// Ruta para desplegar jsp
	@RequestMapping("")
	public String registro() {

		return "registro.jsp"; // pagina a desplegar

	}

	// Ruta para captrur los datos del formulario
	/*
	 * vamos a capturar el valor dentro de name con @requestParam value designado en
	 * name dentro de registro.jsp y la asignamos
	 */
	@RequestMapping("/usuario")
	public String registroUsuario(@RequestParam(value = "nombre") String name) {
		System.out.println("Estamos en el metodo registro de usuario");
		System.out.println(name);
		return "registro.jsp"; // pagina a desplegar

	}
}