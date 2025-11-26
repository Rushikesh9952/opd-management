package com.opd_management.controllers;

import java.net.ResponseCache;
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

import com.opd_management.dtos.ReferralCenterDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.ReferralCenter;
import com.opd_management.repositories.ReferralCenterRepository;
import com.opd_management.services.DoctorService;
import com.opd_management.services.ReferralCenterService;

@RestController
@RequestMapping("/referralceter")
public class ReferralCenterController {
	
	@Autowired
	private ReferralCenterService referralCenterService ;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<ReferralCenter> saveReferralCenter(@RequestBody ReferralCenterDtos referralCenterDtos){
		ReferralCenter referralCenter= new ReferralCenter();
		referralCenter.setAddress(referralCenterDtos.getAddress());
		referralCenter.setContact_info(referralCenterDtos.getContact_info());
		referralCenter.setCreated_at(referralCenterDtos.getCreated_at());
		referralCenter.setName(referralCenterDtos.getName());
		referralCenter.setType(referralCenterDtos.getType());
		
		Doctor doctor =doctorService.getById(referralCenterDtos.getDoctor_id());
		referralCenter.setDoctor_id(doctor);
		
		ReferralCenter saveReferralCetner=referralCenterService.save(referralCenter);
		return new ResponseEntity<>(saveReferralCetner,HttpStatus.CREATED);
}
	
	@GetMapping("/")
	public ResponseEntity<List<ReferralCenter>> getAllReferralCenter(){
		List<ReferralCenter> referralCenters=referralCenterService.listOfReferralCenter();
		if(referralCenters==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referralCenters,HttpStatus.FOUND);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ReferralCenter> getReferralCenterById(@PathVariable("id") int id){
		ReferralCenter referralCenter=referralCenterService.getById(id);
		if(referralCenter==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referralCenter,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReferralCenter> updateReferralCenter(@PathVariable("id") int id,@RequestBody ReferralCenterDtos referralCenterDtos){
		ReferralCenter referralCenter= new ReferralCenter();
		referralCenter.setAddress(referralCenterDtos.getAddress());
		referralCenter.setContact_info(referralCenterDtos.getContact_info());
		referralCenter.setCreated_at(referralCenterDtos.getCreated_at());
		referralCenter.setName(referralCenterDtos.getName());
		referralCenter.setType(referralCenterDtos.getType());
		
		Doctor doctor =doctorService.getById(referralCenterDtos.getDoctor_id());
		referralCenter.setDoctor_id(doctor);
		
		ReferralCenter updatedreferralCenter=referralCenterService.save(referralCenter);
		return new ResponseEntity<>(updatedreferralCenter,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteReferralCenterById(@PathVariable("id") int id){
		ReferralCenter referralCenter=referralCenterService.getById(id);
		if(referralCenter==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referralCenterService.deleteReferralById(id);
		return new ResponseEntity<>(HttpStatus.FOUND);
	}
}
