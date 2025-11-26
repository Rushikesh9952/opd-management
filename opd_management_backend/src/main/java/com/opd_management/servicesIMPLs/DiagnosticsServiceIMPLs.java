package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Diagnostics;
import com.opd_management.entities.Doctor;
import com.opd_management.repositories.DiagnosticsRepository;
import com.opd_management.services.DiagnosticsService;

@Service
public class DiagnosticsServiceIMPLs implements DiagnosticsService {
	
	@Autowired
	private DiagnosticsRepository diagnosticsRepository;

	@Override
	public Diagnostics save(Diagnostics diagnostics) {
		// TODO Auto-generated method stub
		return diagnosticsRepository.save(diagnostics);
	}

	@Override
	public List<Diagnostics> listOfDiagnostics() {
		// TODO Auto-generated method stub
		return diagnosticsRepository.findAll();
	}

	@Override
	public Diagnostics getById(int id) {
		// TODO Auto-generated method stub
		return diagnosticsRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		diagnosticsRepository.deleteById(id);
	}
	
	

}
