package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Bill;

public interface IBillService {
	
	/**
	 * Save bill.
	 *
	 * @param newBill the new bill
	 * @return the bill
	 */
	
	public Bill saveBill(Bill newBill);
	
	List<Bill> getAllBills(); 
	
	Bill getBillById(int id);
	
	void updateBill(Bill u);
	
	void deleteBill(int id);
	
	long countBill();
	
}
