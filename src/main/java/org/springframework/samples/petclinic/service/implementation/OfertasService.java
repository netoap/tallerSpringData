package org.springframework.samples.petclinic.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.repository.OfertasRepository;
import org.springframework.samples.petclinic.service.IOfertasService;
import org.springframework.stereotype.Service;

@Service
public class OfertasService implements IOfertasService{
	@Autowired
	private OfertasRepository ofertasRepo;
	
	@Override
	public List<Ofertas> getAllOfertas() {		
		return ofertasRepo.findAll();
	}

	@Override
	public Ofertas getOfertaById(int id) {
		return ofertasRepo.findOne(id);
	}

	@Override
	public void updateOferta(Ofertas oferta) {
		Ofertas oferta2 = ofertasRepo.findOne(oferta.getId());
		oferta2.setDiscount(oferta.getDiscount());
		ofertasRepo.save(oferta2);
	}

	@Override
	public void deleteOfertas(int id) {
		ofertasRepo.delete(id);			
	}

	@Override
	public void save(Ofertas oferta) {
		ofertasRepo.save(oferta);	
	}

	@Override
	public List<Ofertas> findByExpireDate() {
		Date date = new Date();
		return ofertasRepo.findByExpireDateGreaterThan(date);
	}
	
	
}
