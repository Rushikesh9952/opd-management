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

import com.opd_management.dtos.PatientDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController  {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patients=patientService.listOfPatient();
		if(patients==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patients,HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<Patient> savaPatient(@RequestBody PatientDtos patientDtos ){
		Patient patient = new Patient();
		patient.setAddress(patientDtos.getAddress());
		patient.setAge(patientDtos.getAge());
		patient.setAlcohol(patientDtos.getAlcohol());
		
		Doctor doctor=doctorService.getById(patientDtos.getDoctor_id());
		patient.setDoctor_id(doctor);
		
		patient.setCreated_id(patientDtos.getCreated_id());
		patient.setBlood_group(patientDtos.getBlood_group());
		patient.setHeight(patientDtos.getHeight());
		patient.setMobileno(patientDtos.getMobileno());
		patient.setPatient_name(patientDtos.getPatient_name());
		patient.setTobacco(patientDtos.getTobacco());
		patient.setSmkoking(patientDtos.getSmkoking());
		
		Patient savePatient=patientService.save(patient);
		return new ResponseEntity<>(savePatient ,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id){
		Patient patient=patientService.getById(id);
		if(patient==null) {
			return new ResponseEntity<>(patient,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patient,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id,@RequestBody PatientDtos patientDtos){
		Patient patient=patientService.getById(id);
		
		patient.setAddress(patientDtos.getAddress());
		patient.setAge(patientDtos.getAge());
		patient.setAlcohol(patientDtos.getAlcohol());
		
		Doctor doctor=doctorService.getById(patientDtos.getDoctor_id());
		patient.setDoctor_id(doctor);
		
		patient.setCreated_id(patientDtos.getCreated_id());
		patient.setBlood_group(patientDtos.getBlood_group());
		patient.setHeight(patientDtos.getHeight());
		patient.setMobileno(patientDtos.getMobileno());
		patient.setPatient_name(patientDtos.getPatient_name());
		patient.setTobacco(patientDtos.getTobacco());
		patient.setSmkoking(patientDtos.getSmkoking());
		
		Patient updatedPatient=patientService.save(patient);
		return new ResponseEntity<>(updatedPatient ,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Patient patient=patientService.getById(id);
		if(patient==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patientService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
}
