package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Pet;

public interface IPetService  {		
	List<Pet> findByOrderByBirthDate( Date birthDate);
}
