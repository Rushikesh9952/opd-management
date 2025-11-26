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

import com.opd_management.dtos.DiagnosticsDtos;
import com.opd_management.entities.Diagnostics;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Visit;
import com.opd_management.services.DiagnosticsService;
import com.opd_management.services.DoctorService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/diagnostics")  
public class DiagnosticsController {
 
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private DiagnosticsService diagnosticsService;
	
	@PostMapping("/")
	public ResponseEntity<Diagnostics> saveDiagnostics(@RequestBody DiagnosticsDtos diagnosticsDtos){
		Diagnostics diagnostics=new Diagnostics();
		diagnostics.setName(diagnosticsDtos.getName());
		diagnostics.setDatetime(diagnosticsDtos.getDatetime());
		 
		Visit visit=visitService.getById(diagnosticsDtos.getVisit_id());
		diagnostics.setVisit_id(visit);
		
		Doctor doctor=doctorService.getById(diagnosticsDtos.getDoctor_id());
		diagnostics.setDoctor_id(doctor);
		
		Diagnostics savediagnostics=diagnosticsService.save(diagnostics);
		return new ResponseEntity<>(savediagnostics,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Diagnostics>> getAllDiagnostics(){
		List<Diagnostics> diagnostics=diagnosticsService.listOfDiagnostics();
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostics,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostics> getDiagnosticsById(@PathVariable("id") int id){
		Diagnostics diagnostics=diagnosticsService.getById(id);
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostics,HttpStatus.FOUND);
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostics> updateDiagnostic(@PathVariable("id") int id,@RequestBody DiagnosticsDtos diagnosticsDtos ){
		Diagnostics diagnostics=new Diagnostics();
		diagnostics.setName(diagnosticsDtos.getName());
		diagnostics.setDatetime(diagnosticsDtos.getDatetime());
		 
		Visit visit=visitService.getById(diagnosticsDtos.getVisit_id());
		diagnostics.setVisit_id(visit);
		
		Doctor doctor=doctorService.getById(diagnosticsDtos.getDoctor_id());
		diagnostics.setDoctor_id(doctor);
		
		Diagnostics updatediagnostics=diagnosticsService.save(diagnostics);
		return new ResponseEntity<>(updatediagnostics,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
		Diagnostics diagnostics=diagnosticsService.getById(id);
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		diagnosticsService.deleteById(id);		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
}
