package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Ofertas;

public interface IOfertasService {	
	
	List<Ofertas> getAllOfertas(); 
	
	List<Ofertas> findByExpireDate();
	
	Ofertas getOfertaById(int id);
	
	void updateOferta(Ofertas u);
	
	void deleteOfertas(int id);
	
	void save(Ofertas o);
	
}
