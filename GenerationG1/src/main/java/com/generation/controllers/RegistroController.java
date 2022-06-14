package com.generation.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.models.Usuario;

@Controller
@RequestMapping("/registro") // asiganamos por default /registro
public class RegistroController {

	// Ruta para desplegar jsp
	@RequestMapping("")
	// Pasando un objeto vacio
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		// Pasamos el objeto usuario vacio
		return "registro.jsp"; // pagina a desplegar

	}

	// Ruta para captrur los datos del formulario
	/*
	 * vamos a capturar el valor dentro de name con @requestParam value designado en
	 * name dentro de registro.jsp y la asignamos
	 */
	@PostMapping("/usuario/respaldo")
	public String registroUsuario(@RequestParam(value = "nombre") String name,
			@RequestParam(value = "apellido") String apellido, @RequestParam(value = "edad") int edad) {
		System.out.println("Estamos en el metodo registro de usuario");
		System.out.println("el nombre es: " + name + " " + apellido + " La edad es: " + edad);
		return "registro.jsp"; // pagina a desplegar

	}

	@PostMapping("/usuario")
	public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult resultado,
			Model model) { // siempre Model model para enviar datos desde el controlador al jsp

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "registro.jsp";
		}

		// Capturamos el objeto usuario con los atributos llenos
		System.out.println(usuario.getNombre() + " " + usuario.getApellido() + " " + usuario.getEdad());

		return "index.jsp"; // pagina a desplegar

	}
}