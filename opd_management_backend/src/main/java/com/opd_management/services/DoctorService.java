package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Doctor;

public interface DoctorService {
	
	Doctor save(Doctor doctor);
	List<Doctor> listOfDoctors();
	Doctor getById(int id);
	void deleteById(int id);
	

}
