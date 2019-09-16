package org.springframework.samples.petclinic.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.service.IPetService;
import org.springframework.stereotype.Service;
@Service
public class PetService implements IPetService {

	@Autowired
	PetRepository petRepo;
	
	@Override
	public List<Pet> findByOrderByBirthDate(Date birthDate) {
		return petRepo.findByOrderByBirthDate(birthDate);
	}

}
