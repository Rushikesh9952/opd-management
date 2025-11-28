package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Bill;
import com.opd_management.repositories.BillRepository;
import com.opd_management.services.BillService;
@Service
public class BillServieIMPLs implements BillService{
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill save(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public Bill getById(int id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		billRepository.deleteById(id);
	}
 
}
