package com.prueba.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.models.Mueble;
import com.prueba.services.MuebleService;

@Controller
@RequestMapping("/index") //Asiganmos por default la pagina index
public class RegistroMuebles {
	//Inyeccion de dependencia
	@Autowired
	MuebleService muebleService;
	
	//Ruta para desplegar jsp
	@PostMapping("/guardar")
	public String guardarMueble(@Valid @ModelAttribute("mueble") Mueble mueble, BindingResult resultado, Model model) { // siempre

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "index.jsp";
		}


		// enviar el objeto al service
		muebleService.saveMueble(mueble);

		// obtener una lista de autos
		List<Mueble> listaMuebles = muebleService.findAll();
		// Pasamos la lista de auto al jsp
		model.addAttribute("mueblesCapturados", listaMuebles);

		return "listaMuebles.jsp"; // pagina a desplegar
	}
}
