package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Doctor;
import com.opd_management.repositories.DoctorRepository;
import com.opd_management.services.DoctorService;

@Service
public class DoctorServiceIMPLs implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository ;
	
	@Override
	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> listOfDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}

}
