package org.springframework.samples.petclinic.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.service.IVisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitService implements IVisitService{
	
	@Autowired
	VisitRepository visitRepo;
	
	@Override
	public List<Visit> findByPetId(Integer petId) {
		return visitRepo.findByPetId(petId);
	}
	
	@Override
	public List<Visit> findTop4ByOrderByDateDesc() {
		return visitRepo.findTop4ByOrderByDateDesc();
	}
	
	public void save(Visit v) {
		visitRepo.save(v);
	}

	
	

	

}
