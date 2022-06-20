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
	
	
}
