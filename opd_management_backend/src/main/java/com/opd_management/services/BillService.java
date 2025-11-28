package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Bill;

public interface BillService {
	
	Bill save(Bill bill);
	List<Bill> getAllBills();
	Bill getById(int id);
	void deleteById(int id);

}
