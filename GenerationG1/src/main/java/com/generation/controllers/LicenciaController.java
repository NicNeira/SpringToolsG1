package com.generation.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;
import com.generation.models.Usuario;
import com.generation.services.LicenciaServices;
import com.generation.services.UsuarioService;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {

	@Autowired
	LicenciaServices licenciaServices;

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("")
	public String despliegue(Model model) {
		Licencia licencia = new Licencia();
		// licencia.setEstado("activo");
		model.addAttribute("licencia", licencia);
		// Lista de usuario
		List<Usuario> listaUsuarios = usuarioService.findAll();
		// pasar lista
		model.addAttribute("listaUsuarios", listaUsuarios);

		// Enviar al jsp lista de Licencias
		List<Licencia> listaLicencias = licenciaServices.findAll();
		// pasar al jsp
		model.addAttribute("listaLicencias", listaLicencias);

		Date fechaActual = new Date();
		/*
		 * model.addAttribute("fechaActual",fechaActual); SimpleDateFormat
		 */

		return "licencia.jsp";
	}

	@PostMapping("/guardar")
	public String guardarLicencia(@Valid @ModelAttribute("licencia") Licencia licencia) {
		licenciaServices.save(licencia);

		return "redirect:/licencia";
	}
}
