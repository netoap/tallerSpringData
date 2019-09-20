package org.springframework.samples.petclinic.junit;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.service.implementation.OfertasService;
import org.springframwork.samples.petclinic.databasetest.baseDeDadosDeOfertas;

@RunWith(MockitoJUnitRunner.class)
public class OfertasTest {
	
	
	@InjectMocks
	static OfertasService service;
	
	@Mock
	private baseDeDadosDeOfertas BBDD;

	//OfertasService service= new OfertasService();
	List<Ofertas>ofertaslist=new ArrayList<Ofertas>();
	//Ofertas oferta=new Ofertas();
	
	@BeforeClass
	public static void testInit() {
		System.out.println("in beforeclass");
		
		
		
	}
	
	
	
	@Test
	public void getAllOfertas() {
		/*
		assertEquals
		service.save(oferta);
		*/
		
	}
	
	@Test
	public void saveTest() {
		
		int beforesize=ofertaslist.size();
		
		BBDD.
		
		
		
	}
	
	
	
	
	
	
	
	
	@AfterClass
	public static void testInitexit() {
		System.out.println("in after");
		
		
	}
	
	
	
}
