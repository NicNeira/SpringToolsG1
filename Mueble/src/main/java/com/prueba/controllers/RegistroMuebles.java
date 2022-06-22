package com.prueba.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.models.Mueble;
import com.prueba.services.MuebleService;

@Controller
@RequestMapping("") // Asiganmos por default la pagina index
public class RegistroMuebles {
	// Inyeccion de dependencia
	@Autowired
	MuebleService muebleService;

	// Ruta para desplegar jsp
	@RequestMapping("/index")
	public String inicio(@ModelAttribute("mueble") Mueble mueble, Model model) {
		System.out.println("Estoy aqui");
		return "index.jsp";
	}

	// Ruta en la cual indicamos que guarde los datos ingresados en la tabla
	@PostMapping("/guardar")
	public String guardarMueble(@Valid @ModelAttribute("mueble") Mueble mueble, BindingResult resultado, Model model) { // siempre

		// Si hay algun error en los datos ingresados nos muestra este error (Se definen
		// en el objeto*)
		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que

			// muestre que hay un error y retorna a la pagina principal
			return "index.jsp";
		}

		// enviar el objeto al package service
		muebleService.saveMueble(mueble);

		// obtener una lista de muebles
		List<Mueble> listaMuebles = muebleService.findAll();
		// Pasamos la lista de muebles al jsp
		model.addAttribute("mueblesCapturados", listaMuebles);

		// Retornamos la pagina listamuebles con los datos ingresados
		return "listaMuebles.jsp"; // pagina a desplegar
	}

	// ruta para solo mostrar la lista
	@RequestMapping("/mostrarLista")
	public String mostrarLista(Model model) {

		// obtener la lista de muebles registrados
		List<Mueble> listaMuebles = muebleService.findAll();
		// Pasamos la lista de muebles al jsp
		model.addAttribute("mueblesCapturados", listaMuebles);

		return "listaMuebles.jsp"; // pagina a desplegar
	}

	@RequestMapping("/editar/{id}") // Editar para el despliege
	// @PathVariable para configurar variables dentro de los propios segmentos de la
	// URL
	public String editarMueble(@PathVariable("id") Long id, Model model) {

		Mueble mueble = muebleService.editarMuebleId(id);
		// El Model es para pasar algo al jsp
		model.addAttribute("mueble", mueble);

		return "editarAuto.jsp";
		// return "redirect;/autoTuneado/mostrar"; // redirect para redireccionar a otra
		// url o path
	}

	// Ruta para actualizar el elemento por id
	@PostMapping("/actualizar/{id}")
	public String actualizarMeuble(@PathVariable("id") Long id, @Valid @ModelAttribute("mueble") Mueble mueble,
			BindingResult resultado, Model model) {

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "index.jsp";
		} else {
			mueble.setId(id); // --> agregar el id al objeto
			// enviamos el objeto a persistir en base de datos
			muebleService.actualizarMueble(mueble);
			// obtener una lista de muebles
			List<Mueble> listaMuebles = muebleService.findAll();
			// Pasamos la lista de muebles al jsp
			model.addAttribute("mueblesCapturados", listaMuebles);

			return "listaMuebles.jsp"; // pagina que contiene todos los datos ingresados
		}
	}

}
