package com.opd_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.BillDtos;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Visit;
import com.opd_management.services.BillService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	@Autowired
	private VisitService visitService;
	
	@PostMapping("/")
	public ResponseEntity<Bill> saveBill(@RequestBody BillDtos billDtos){
		Bill bill =new Bill();
		bill.setConcession(billDtos.getConcession());
		bill.setConsultation_fee(billDtos.getConsultation_fee());
		bill.setCreated_at(billDtos.getCreated_at());
		bill.setPayment_amount(billDtos.getPayment_amount());
		bill.setPayment_mode(billDtos.getPayment_mode());
		bill.setPayment_status(billDtos.getPayment_status());
		bill.setPending_amount(billDtos.getPending_amount());
		bill.setTotal_amount(billDtos.getTotal_amount());
		
		Visit visit=visitService.getById(billDtos.getVisit_id());
		bill.setVisit_id(visit);
		
		Bill saveBill=billService.save(bill);
		return new ResponseEntity<>(saveBill,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> getAllBill(){
		List<Bill> bills=billService.getAllBills();
		if(bills==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bills,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bill> getBillByID(@PathVariable("id") int id){
		
		Bill bill = billService.getById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bill, HttpStatus.FOUND);
		
	}
 	
	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateBillById(@PathVariable("id") int id, @RequestBody BillDtos billDtos){
		
		Bill bill = billService.getById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		bill.setConcession(billDtos.getConcession());
		bill.setConsultation_fee(billDtos.getConsultation_fee());
		bill.setCreated_at(billDtos.getCreated_at());
		bill.setPayment_amount(billDtos.getPayment_amount());
		bill.setPayment_mode(billDtos.getPayment_mode());
		bill.setPayment_status(billDtos.getPayment_status());
		bill.setPending_amount(billDtos.getPending_amount());
		bill.setTotal_amount(billDtos.getTotal_amount());
		
		Visit visit=visitService.getById(billDtos.getVisit_id());
		bill.setVisit_id(visit);
		Bill updatedBill=billService.save(bill);
		return new ResponseEntity<>(updatedBill,HttpStatus.ACCEPTED); 
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBillById(@PathVariable("id") int id){
		Bill bill = billService.getById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		billService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}

}
