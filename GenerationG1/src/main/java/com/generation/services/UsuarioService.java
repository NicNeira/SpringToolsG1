package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public void saveUsuario(@Valid Usuario usuario) {
		// llamar al repossitory (Inyeccion de dependencia)
		
		//Funcion guardar
		usuarioRepository.save(usuario);
		
	}

	public  List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	/* Logica de negocio o validaciones del sistema */
	/* Llamar al repository (Inyeccion de dependencia) */

}
