package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	// Guardar un auto
	public void saveAuto(@Valid Auto auto) {
		// llamar al repossitory (Inyeccion de dependencia)

		// Funcion guardar
		autoRepository.save(auto);

	}

	public List<Auto> findAll() {
		// Creamos metodo a partir del controller para obtener lista de auto
		return autoRepository.findAll();
	}

	public Auto buscarId(Long id) {
		// metodo para buscar el id del objeto auto
		return autoRepository.findById(id).get(); // .get especifica el tipo de dato que necesitamos (En este caso auto)
	}

	public void eliminarAuto(@Valid Long id) {
		// Metodo para eliminar auto selecionado
		
		autoRepository.deleteById(id);
	

	}

	public void guardarAuto(@Valid Auto auto) {
		// funcion que guarda el auto actualizado
		autoRepository.save(auto);

	}

}
