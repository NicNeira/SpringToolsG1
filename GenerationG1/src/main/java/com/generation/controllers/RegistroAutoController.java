package com.generation.controllers;

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

	// Una ruta para solo mostrar el jsp con la lista de auto
	@RequestMapping("/mostrar")
	public String mostrar(Model model) {

		// obtener una lista de autos
		List<Auto> listaAutos = autoService.findAll();
		// Pasamos la lista de auto al jsp
		model.addAttribute("autosCapturados", listaAutos);

		return "registroAuto.jsp"; // pagina a desplegar
	}

	// @RequestMapping Anotaci??n que se encarga de relacionar un m??todo con una
	// petici??n http.
	@RequestMapping("/editar/{id}") // Editar para el despliege
	// @PathVariable para configurar variables dentro de los propios segmentos de la
	// URL
	public String editarAuto(@PathVariable("id") Long id, Model model) {
		// Para mostrar que se esta recibiendo el id
		System.out.println("El id es: " + id);

		Auto auto = autoService.buscarId(id);
		// El Model es para pasar algo al jsp
		model.addAttribute("auto", auto);

		return "editarAuto.jsp";
		// return "redirect;/autoTuneado/mostrar"; // redirect para redireccionar a otra
		// url o path
	}

	// localhost:9080/autoTuneado/actualizar/{id} --> //Actualizar para la
	// persistencia en la base de datos

	@PostMapping("/actualizar/{id}")
	public String actualizarAuto(@PathVariable("id") Long id, @Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado, Model model) {

		System.out.println("el id a actualizar es: " + id);

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "autoTuneado.jsp";
		} else {
			auto.setId(id); // --> agregar el id al objeto
			// enviamos el objeto a persistir en base de datos
			autoService.guardarAuto(auto);
			// obtener una lista de autos
			List<Auto> listaAutos = autoService.findAll();
			// Pasamos la lista de auto al jsp
			model.addAttribute("autosCapturados", listaAutos);

			return "registroAuto.jsp"; // pagina a desplegar
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarAuto(@PathVariable("id") Long id) { // siempre

		// Funcion para eliminar el auto ingresado en la tabla
		autoService.eliminarAuto(id);

		return "redirect:/autoTuneado/mostrar";
		
	}

	}

