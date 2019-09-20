package org.springframework.samples.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.service.IOfertasService;
import org.springframework.samples.petclinic.service.implementation.OfertasService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ofertas")
public class OfertasController {

	@Autowired
	private IOfertasService ofertasService;

	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Ofertas> findAll() {
		return ofertasService.getAllOfertas();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Ofertas findById(@PathVariable Integer id) {
		return ofertasService.getOfertaById(id);
	}
	
	@RequestMapping(value = "/ofertasAtuais", method = RequestMethod.GET)
	public List<Ofertas> ofertasAtuais() {
		return ofertasService.findByExpireDate();
	}
	
	@RequestMapping(value = "/createOfertas", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createOfertas(@RequestBody Ofertas newOfertas) {
		ofertasService.save(newOfertas);
	}	

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateOferta(@RequestBody Ofertas updOfertas) {
		ofertasService.updateOferta(updOfertas);
	}
	
	@RequestMapping(value = "/deleteOferta/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOfertaById(@PathVariable Integer id) {
		ofertasService.deleteOfertas(id);
	}
}
