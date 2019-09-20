/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.SpecialityRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.service.IOfertasService;
import org.springframework.samples.petclinic.service.IVisitService;
import org.springframework.samples.petclinic.service.implementation.OwnerService;
import org.springframework.samples.petclinic.service.implementation.PetService;


/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	@Autowired
	VetRepository vetRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	OwnerService ownerService;
	@Autowired
	PetService petService;
	@Autowired
	IVisitService visitService;
	@Autowired
	IOfertasService ofertasService;
	
	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");

//			log.info("Creamos un obj vet");
//			Vet vet = new Vet();
//        	vet.setFirstName("Bob");
//        	vet.setLastName("Tareq");
//        	
//        	log.info("Persistimos en BD");        	
//    		vet = vetRepository.save(vet);
//    		
//    		log.info("COmprobbamos que se ha creado correctamente");
//    		Vet vetAux = vetRepository.findOne(vet.getId());
//    		
//    		log.info("Editamos el obj y anadimos una Speciality");
//    		Specialty speciality = specialityRepository.findOne(1);
//    		vet.addSpecialty(speciality);
//    		vet = vetRepository.save(vet);
//    		log.info(vet.toString());
//    		
//    		log.info("Listamos todos los veterinarios");
//			for(Vet v : vetRepository.findAll()) {
//				log.info("Vet: " + v);
//			}		
//			List<Vet> vetsLastName = vetRepository.findByLastName("Tareq");
//			List<Vet> vetsFirstNameAndLastName = vetRepository.findByFirstNameAndLastName("Bob", "Tareq");
//			List<Vet> vetsFirstNameOrLastName = vetRepository.findByFirstNameOrLastName("James", "Carter");
//			
//			for(Vet v : vetsLastName) {
//				log.info("vetsLastName: " + v);
//			}
//			for(Vet v : vetsFirstNameAndLastName) {
//				log.info("vetsFirstNameAndLastName: " + v);
//			}
//			
//			for(Vet v : vetsFirstNameOrLastName) {
//				log.info("vetsFirstNameOrLastName: " + v);
//			}
//			
//			
//			for(Vet v : vetRepository.findBySpecialityName("radiology")) {
//				log.info("vetsSpecialityName: " + v);
//			}
		
//			log.info("ById: " + ownerRepository.findById(1));
//		
//			for(Owner v : ownerRepository.findByFirstNameContainingOrLastNameContaining("Bob","Tareq")) {
//				log.info("ByFirstNameContainingOrLastNameContaining: " + v);
//			}
//			
//			for(Owner v : ownerRepository.searchOwner("George")) {
//				log.info("ByFirstNameContainingOrLastNameContaining: " + v);
//			}
//			
//			for(Owner v : ownerRepository.findByOrderByLastName()) {
//				log.info("findByOrderByLastName: " + v);
//			}
			
			/**********************************SERVICE OWNER*******************************/
			
//			log.info("ById: " + ownerService.findById(1));
//		
//			for(Owner v : ownerService.findByFirstNameContainingOrLastNameContaining("Bob","Tareq")) {
//				log.info("ByFirstNameContainingOrLastNameContaining: " + v);
//			}
//			
//			for(Owner v : ownerService.findByOrderByLastName()) {
//				log.info("findByOrderByLastName: " + v);
//			}
			
			/**********************************SERVICE Pet*******************************/
			//Obtener las mascotas nascidas en 2010 ordenadas por fecha de nascimento ascendente
			Date date = Date.from(LocalDate.of(2000,9,07).atStartOfDay(ZoneId.systemDefault()).toInstant());			
			
			for(Pet p : petService.findByOrderByBirthDate(date)) {
				log.info("findByOrderByBirthDate: " + p);
			}
			/**********************************SERVICE Visit*******************************/
			// Crear 3 visitas nuevas para diferentes mascotas
			
			Visit v1 = new Visit();
			
			v1.setPetId(1);
			v1.setDate(date);
			v1.setDescription("spayed1");
			
			
			Visit v2 = new Visit();
			v2.setPetId(2);
			v2.setDate(date);
			v2.setDescription("spayed2");
			
			
			Visit v3 = new Visit();
			v3.setPetId(3);
			v3.setDate(date);
			v3.setDescription("spayed3");
			
			
			// Salvar 3 visitas nuevas para diferentes mascotas
			visitService.save(v1);
			visitService.save(v2);
			visitService.save(v3);
			
			// Obtener todas las visitas para una mascota
			visitService.findByPetId(1);			
			
			// Obtener las 4 visitas más recientes de todo el sistema.
			for(Visit v : visitService.findTop4ByOrderByDateDesc()) {
				log.info("findTop4ByVisit: " + v);
			}
			
			/**************************** ofertas Service*******************/
			// INSERT- CREATE
			
			Ofertas oferta1 = new Ofertas();
			oferta1.setTitle("oferta1");
			oferta1.setDescription("Desc1");
			oferta1.setDiscount(10D);
			Date dateDeExpiracao = Date.from(LocalDate.of(2019,8,01).atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			
			oferta1.setExpireDate(dateDeExpiracao);	
			
			Ofertas oferta2 = new Ofertas();
			oferta2.setTitle("oferta2");
			oferta2.setDescription("Desc2");
			oferta2.setDiscount(10D);
			Date dateDeExpiracao1 = Date.from(LocalDate.of(2020,11,01).atStartOfDay(ZoneId.systemDefault()).toInstant());
			oferta2.setExpireDate(dateDeExpiracao1);
			
//			ofertasService.save(oferta1);
//			ofertasService.save(oferta2);
//			SELECT ALL
			for (Ofertas oferta : ofertasService.getAllOfertas()) {
				System.out.println(oferta);
			}
			//SELECT registos que nao caducaram
			//Date todayDate = Date.from(LocalDate.of(2019,8,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
			List<Ofertas> ofertasX = ofertasService.findByExpireDate();
			
			for (Ofertas oferta : ofertasX) {
				System.out.println("Nao Caducadas: "+oferta);
			}
			
			// DELETE oferta (checked)
			//ofertasService.deleteOfertas(1);
			
			// UPDATE no POSTMAN
		};
	}   
}
