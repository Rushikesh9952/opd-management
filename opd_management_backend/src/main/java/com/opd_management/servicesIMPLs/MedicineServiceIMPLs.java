package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Medicine;
import com.opd_management.repositories.MedicineRepository;
import com.opd_management.services.MedicineService;
@Service
public class MedicineServiceIMPLs implements MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public Medicine save(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> listOfMedicines() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public Medicine getById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(id);
	}
	
	

}
