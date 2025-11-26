package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Diagnostics;
import com.opd_management.entities.Doctor;

public interface DiagnosticsService {
	
	Diagnostics save(Diagnostics diagnostics);
	List<Diagnostics> listOfDiagnostics();
	Diagnostics getById(int id);
	void deleteById(int id);
	

}
