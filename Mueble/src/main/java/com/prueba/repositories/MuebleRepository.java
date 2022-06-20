package com.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.models.Mueble;


@Repository
public interface MuebleRepository extends JpaRepository<Mueble, Long > { //JpaRepository<Objeto,Tipo_dato_FK >
	/*Las interface solo definen los metodos*/
	/*Aqui nosotros ejecutamos las query y usar metodos que se conectan a la base de datos*/
	
}
