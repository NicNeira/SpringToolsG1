package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Auto;
import com.generation.services.AutoService;

@Controller
@RequestMapping("/autoTuneado") // asiganamos por default /registro
public class RegistroAutoController {
	// inyeccion de dependencia
	@Autowired
	AutoService autoService;

	// Ruta para desplegar jsp
	@RequestMapping("")
	// Pasando un objeto vacio
	public String inicio(@ModelAttribute("auto") Auto auto) {
		// Pasamos el objeto usuario vacio
		return "autoTuneado.jsp"; // pagina a desplegar

	}

	@PostMapping("/guardar")
	public String guardarAuto(@Valid @ModelAttribute("auto") Auto auto, BindingResult resultado, Model model) { // siempre

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "autoTuneado.jsp";
		}

		// Capturamos el objeto usuario con los atributos llenos
		System.out.println(auto.getMarca() + " " + auto.getModelo() + " " + auto.getColor() + " " + auto.getPatente());

		// enviar el objeto al service
		autoService.saveAuto(auto);

		// obtener una lista de autos
		List<Auto> listaAutos = autoService.findAll();
		// Pasamos la lista de auto al jsp
		model.addAttribute("autosCapturados", listaAutos);

		return "registroAuto.jsp"; // pagina a desplegar
	}
}
