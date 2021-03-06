package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Usuario;

@Controller // Importar clase de tipo controlador
public class IndexController {

	// http://localhost:9080/
	@RequestMapping("/") // Anotacion para capturar las rutas
	public String index(Model model) {

		model.addAttribute("apellidos", "Neira Lopez");
		model.addAttribute("nombres", "Nicolas Neira");
		model.addAttribute("edad", 27);

		// Instancia de usuario
		Usuario usuario = new Usuario("Alan", "Brito", 20, "Alan123");

		// pasando el objeto usuario a la vista (JSP)
		model.addAttribute("usuario", usuario);

		return "index.jsp";

	}
}