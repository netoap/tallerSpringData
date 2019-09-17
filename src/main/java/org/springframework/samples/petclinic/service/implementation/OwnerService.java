package org.springframework.samples.petclinic.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.service.IOwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {
	
	@Autowired
	OwnerRepository ownerRepo;

	@Override
	public void save(Owner o) {
		ownerRepo.save(o);	
	}

	@Override
	public Owner findById(Integer id) {		
		return ownerRepo.findById(id);
	}

	@Override
	public List<Owner> findByFirstNameContainingOrLastNameContaining(String firstname, String lastname) {		
		return ownerRepo.findByFirstNameContainingOrLastNameContaining(firstname, lastname);
	}

	@Override
	public List<Owner> findByOrderByLastName() {		
		return ownerRepo.findByOrderByLastName();
	}
	
}
