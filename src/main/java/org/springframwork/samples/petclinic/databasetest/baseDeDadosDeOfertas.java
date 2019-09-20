package org.springframwork.samples.petclinic.databasetest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Ofertas;

public class baseDeDadosDeOfertas {
	
	
	Date date1 = Date.from(LocalDate.of(2019,8,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date2 = Date.from(LocalDate.of(2013,8,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date3 = Date.from(LocalDate.of(2029,8,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date4 = Date.from(LocalDate.of(2019,1,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date5 = Date.from(LocalDate.of(2019,11,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date6 = Date.from(LocalDate.of(2084,1,12).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date7 = Date.from(LocalDate.of(2010,8,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date8 = Date.from(LocalDate.of(2069,7,20).atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date9 = Date.from(LocalDate.of(2021,8,14).atStartOfDay(ZoneId.systemDefault()).toInstant());
	

	List<Ofertas>listofertas=new ArrayList<Ofertas>(
			Arrays.asList(
					new Ofertas ("title1","description1",10d,date1),
					new Ofertas ("title2","description2",20d,date2),
					new Ofertas ("title3","description3",30d,date3),
					new Ofertas ("title4","description4",40d,date4),
					new Ofertas ("title5","description5",50d,date5),
					new Ofertas ("title6","description6",60d,date6),
					new Ofertas ("title7","description7",70d,date7),
					new Ofertas ("title8","description8",80d,date8),
					new Ofertas ("title9","description9",90d,date9)
					));
			
	
	public Ofertas findbyId(int id) {
		
		for(int i=0;i<listofertas.size();i++) {
			
			Integer a=listofertas.get(i).getId();
			if(a==id) {
				return listofertas.get(i);
			}
		}
		return null;
			
			
		}
		
		
	}
	

