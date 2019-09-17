package org.springframework.samples.petclinic.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.samples.petclinic.service.IBillService;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService{
	
	@Autowired
	private BillRepository billRepo;
	
	public Bill saveBill(Bill newBill) {
		return billRepo.save(newBill);
	}

	@Override
	public List<Bill> getAllBills() {		
		return billRepo.findAll();
	}

	@Override
	public Bill getBillById(int id) {
		return billRepo.findOne(id);
	}

	@Override
	public void updateBill(Bill u) {
		Bill b = getBillById(u.getId());
		b.setPaymentDate(u.getPaymentDate());
		billRepo.save(b);
	}

	@Override
	public void deleteBill(int id) {
		Bill b = getBillById(id);
		billRepo.delete(b);		
	}

	public List<Bill> billMayorQueVinte(Double d) {
		return billRepo.findByMoneyGreaterThan(d);
	}
	
	public List<Bill> billMenorQueVinte(Double d) {
		return billRepo.findByMoneyLessThan(d);
	}

	@Override
	public long countBill() {
		return billRepo.count();
	}
}
