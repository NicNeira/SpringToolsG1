package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long > { //JpaRepository<Objeto,Tipo_dato_FK >{
	/*Las interface solo definen los metodos*/
	/*Aqui nosotros ejecutamos las query y usar metodos que se conectan a la base de datos*/
	
}
