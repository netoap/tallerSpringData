package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Owner;

public interface IOwnerService {
	
	void save(Owner o);
	Owner findById(Integer id);
	List<Owner> findByFirstNameContainingOrLastNameContaining(String firstname, String lastname);
	List<Owner> findByOrderByLastName();

}
