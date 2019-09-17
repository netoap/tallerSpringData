package org.springframework.samples.petclinic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.exception.ValidationException;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.service.implementation.BillService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillService billService;

	// 1- Obtener todas las facturas de BD
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Bill> getAllBill() {
		return billService.getAllBills();
	}

	// 2- Obtener una factura por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Bill getBillById(@PathVariable int id) {
		return billService.getBillById(id);
	}

	// 3- crear una fatura
	@RequestMapping(value = "/createBill", method = RequestMethod.POST)
	public Bill createBill(@RequestBody Bill bill) {
		return billService.saveBill(bill);
	}
	
	// 4- atualizar el campo payment_date de una factura existente
	
	@RequestMapping(value = "/updateBill", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBill(@RequestBody Bill bill) {
		billService.updateBill(bill);
	}
	
	@RequestMapping(value = "/deleteBill/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBill(@PathVariable int id) {
		
		billService.deleteBill(id);
	}
	
	@RequestMapping(value = "/mayorVinte/{d}", method = RequestMethod.GET)
	public List<Bill> mayorVinte(@PathVariable double d) {
		return billService.billMayorQueVinte(d);
	}
	
	@RequestMapping(value = "/menorVinte/{d}", method = RequestMethod.GET)
	public List<Bill> menorVinte(@PathVariable double d) {
		return billService.billMenorQueVinte(d);
	}
	
	@RequestMapping(value = "/countBill", method = RequestMethod.GET)
	public long countBill() {
		return billService.countBill();
	}
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleIOException(Exception ex, HttpServletRequest request) {
		return "Eception customized ---> " + ex.getMessage();
	}
}
