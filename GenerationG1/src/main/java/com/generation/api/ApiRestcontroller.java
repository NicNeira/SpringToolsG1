package com.generation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.models.Auto;
import com.generation.services.AutoService;


//retornaremos un json**

@RestController
@RequestMapping("/api")
public class ApiRestcontroller {
	
	//Inyeccion de dependencia, (Traer una clase para ser usada con sus metodos)
	@Autowired
	AutoService autoservice;
	
	//localhost:8080/api/obtener/autos
	@RequestMapping("/obtener/autos")
	//Metodo para obtener una lista tipo Auto(objeto)
	public List<Auto> obtenerListaAutos(){
		List<Auto> listaAutos = autoservice.findAll();
		return listaAutos;
	}
	
	//API (JSON) JavaScript Object Notation es un formato basado en texto


	
	
}
