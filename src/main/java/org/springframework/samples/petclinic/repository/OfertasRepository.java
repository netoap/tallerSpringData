package org.springframework.samples.petclinic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Ofertas;

public interface OfertasRepository extends JpaRepository<Ofertas, Integer>{
	
	List<Ofertas> findByExpireDateGreaterThan(Date date);	
	
}
