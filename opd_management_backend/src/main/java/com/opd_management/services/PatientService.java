package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Patient;

public interface PatientService {
	
	Patient save(Patient patient);
	List<Patient> listOfPatient();
	Patient getById(int id);
	void deleteById(int id);

}
