package com.opd_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.ReceptionDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Reception;
import com.opd_management.services.DoctorService;
import com.opd_management.services.ReceptionService;

import jakarta.persistence.GeneratedValue;

@RestController
@RequestMapping("/reception")
public class ReceptionController {
	@Autowired
	private ReceptionService receptionService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<Reception> saveReception(@RequestBody ReceptionDtos receptionDtos){
		Reception reception=new Reception();
		reception.setEmail(receptionDtos.getEmail());
		reception.setMobileno(receptionDtos.getMobileno());
		reception.setName(receptionDtos.getName());
		reception.setPassword(receptionDtos.getPassword());
		reception.setShift(receptionDtos.getShift());
		
		Doctor doctor=doctorService.getById(receptionDtos.getDoctor_id());
		reception.setDoctor_id(doctor);
		
		Reception saveReception=receptionService.save(reception);
		return new ResponseEntity<>(saveReception,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Reception>> getAllReception(){
		List<Reception> receptions=receptionService.getAllReception();
		if(receptions==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(receptions,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reception> getAllReception(@PathVariable("id") int id){
		Reception reception=receptionService.getById(id);
		if(reception==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reception,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reception> updateReceptionById(@PathVariable("id") int id,@RequestBody ReceptionDtos receptionDtos){
		Reception reception=receptionService.getById(id);
		if(reception==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reception.setEmail(receptionDtos.getEmail());
		reception.setMobileno(receptionDtos.getMobileno());
		reception.setName(receptionDtos.getName());
		reception.setPassword(receptionDtos.getPassword());
		reception.setShift(receptionDtos.getShift());
		
		Doctor doctor=doctorService.getById(receptionDtos.getDoctor_id());
		reception.setDoctor_id(doctor);
		
		Reception updateReception=receptionService.save(reception);
		return new ResponseEntity<>(updateReception,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable("id") int id){
		Reception reception=receptionService.getById(id);
		if(reception==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		receptionService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
