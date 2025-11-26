package com.opd_management.controllers;

import java.net.http.HttpClient;
import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.DoctorDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.services.DoctorService;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody DoctorDtos doctorDtos){
		Doctor doctor = new Doctor();
		doctor.setAddress(doctorDtos.getAddress());
		doctor.setClinic_name(doctorDtos.getClinic_name());
		doctor.setCreated_at(doctorDtos.getCreated_at());
		doctor.setEmail(doctorDtos.getEmail());
		doctor.setMobno(doctorDtos.getMobno());
		doctor.setName(doctorDtos.getName());
		doctor.setPassword(doctorDtos.getPassword());
		doctor.setSpecialization(doctorDtos.getSpecialization());
		doctor.setStatus(doctorDtos.getStatus());
		doctor.setToken(doctorDtos.getToken());
		doctor.setUpdated_at(doctorDtos.getUpdated_at());
		
		Doctor saveDoc=doctorService.save(doctor);
		return new ResponseEntity<>(saveDoc,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id){
		Doctor doctor =doctorService.getById(id);
		if(doctor==null) {
			return new ResponseEntity<>(doctor,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctor,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Doctor>> getDoctors(){
		List<Doctor> doctor=doctorService.listOfDoctors();
		if(doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println(doctor);
		return new ResponseEntity<>(doctor,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctortpById(@PathVariable("id") int id,@RequestBody DoctorDtos doctorDtos){
		Doctor doctor=doctorService.getById(id);
		if(doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		doctor.setAddress(doctorDtos.getAddress());
		doctor.setClinic_name(doctorDtos.getClinic_name());
		doctor.setCreated_at(doctorDtos.getCreated_at());
		doctor.setEmail(doctorDtos.getEmail());
		doctor.setMobno(doctorDtos.getMobno());
		doctor.setName(doctorDtos.getName());
		doctor.setPassword(doctorDtos.getPassword());
		doctor.setSpecialization(doctorDtos.getSpecialization());
		doctor.setStatus(doctorDtos.getStatus());
		doctor.setToken(doctorDtos.getToken());
		doctor.setUpdated_at(doctorDtos.getUpdated_at());
		
		Doctor updatedDoctor=doctorService.save(doctor);
		return new ResponseEntity<>(updatedDoctor,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeleteDoctor(@PathVariable("id") int id){
		Doctor doctor =doctorService.getById(id);
		if(doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		doctorService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
