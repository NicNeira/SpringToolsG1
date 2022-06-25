package com.prueba.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.models.Mueble;
import com.prueba.repositories.MuebleRepository;

@Service
public class MuebleService {
	@Autowired
	MuebleRepository muebleRepository;

	//Metodo para guardar mueble
	public void saveMueble(@Valid Mueble mueble) {
		
		muebleRepository.save(mueble);
		
	}

	public List<Mueble> findAll() {
		// Creamos metodo a partir del controller para obtener lista de muebles
		return muebleRepository.findAll();
	}

	public void actualizarMueble(@Valid Mueble mueble) {
		// Metodo para actualizar el elemento con el id seleccionado
		
		muebleRepository.save(mueble);
		
	}


	public Mueble editarMuebleId(Long id) {
		//metodo para editar mueble ya registrado
		return muebleRepository.findById(id).get();
	}

	//Metodo para eliminar el mueble seleccionado (por id)
	public void eliminarAuto(Long id) {
		muebleRepository.deleteById(id);
	}
	
	
}
