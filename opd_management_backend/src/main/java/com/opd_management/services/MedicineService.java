package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Doctor;
import com.opd_management.entities.Medicine;

public interface MedicineService  {
	
	Medicine save(Medicine medicine);
	List<Medicine> listOfMedicines();
	Medicine getById(int id);
	void deleteById(int id);
	
}
