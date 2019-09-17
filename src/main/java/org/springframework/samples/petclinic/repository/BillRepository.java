package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	
//	@Query("select * from facturas where money >=:d")
//	List<Bill> billMayorQueVinte(@Param("d") Double d);
	List<Bill> findByMoneyGreaterThan(Double d);
	List<Bill> findByMoneyLessThan(Double d);
}
