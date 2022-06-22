package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2") // Establecer inicio de ruta por defecto
public class ParametrosRestController {

	// localhost:9080/api?fecha=20220613
	@RequestMapping("/")
	public String fecha(@RequestParam(value = "fecha") String fecha) {

		return "La fecha es: " + fecha;
	}

	// localhost:9080/api/seccion?modulo=3&seccion=5
	// Deben estar los 2 parametro, de lo contrario nos muestra error
	@RequestMapping("/seccion")
	public String seccion(@RequestParam(value = "modulo") String modulo,
			@RequestParam(value = "seccion") String seccion) {

		return "El modulo es: " + modulo + " y la seccion es: " + seccion;
	}
	// Rutas parametros no obligatorios

	// localhost:9080/api/date?anio=2022&mes=6&dia=13
	@RequestMapping("/date")
	public String capturarParametros(@RequestParam(value = "anio", required = false) String anio,
			@RequestParam(value = "mes", required = false) String mes,
			@RequestParam(value = "dia", required = false) String dia) {

		if (anio != null) {
			System.out.println("el año es: " + anio);
		}
		if (mes != null) {
			System.out.println("el mes es: " + mes);
		}
		if (dia != null) {
			System.out.println("el dia es: " + dia);
		}

		return "La fecha es: " + anio + "-" + mes + "-" + dia;
	}

}
