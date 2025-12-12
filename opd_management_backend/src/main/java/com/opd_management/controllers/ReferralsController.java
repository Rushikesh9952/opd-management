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

import com.opd_management.dtos.ReferralsDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.ReferralCenter;
import com.opd_management.entities.Referrals;
import com.opd_management.entities.Visit;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;
import com.opd_management.services.ReferralCenterService;
import com.opd_management.services.ReferralsService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/referrals")
public class ReferralsController {
	
	@Autowired
	private ReferralsService referralsService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ReferralCenterService referralCenterService;
	
	@PostMapping("/")
	public ResponseEntity<Referrals> save(@RequestBody ReferralsDtos referralsDtos){
		Referrals referrals=new Referrals();
		referrals.setCreated_at(referralsDtos.getCreated_at());
		referrals.setDetails(referralsDtos.getDetails());
		referrals.setNote_type(referralsDtos.getNote_type());
		referrals.setReason(referralsDtos.getReason());
		
		
		Doctor doctor=doctorService.getById(referralsDtos.getDoctor_id());
		referrals.setDoctor_id(doctor);
		
		Patient patient=patientService.getById(referralsDtos.getPatient_id());
		referrals.setPatient_id(patient);
		
		Visit visit=visitService.getById(referralsDtos.getVisit_id());
		referrals.setVisit_id(visit);
		
		ReferralCenter referralCenter=referralCenterService.getById(referralsDtos.getReferral_center_id());
		referrals.setReferral_center_id(referralCenter);
		
		Referrals saveReferral=referralsService.save(referrals);
		
		return new ResponseEntity<>(saveReferral,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Referrals>> getAllReferrals(){
		List<Referrals> referrals=referralsService.getAllReferrals();
		if(referrals==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referrals,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Referrals> getReferralsById(@PathVariable("id") int id){
		Referrals referrals=referralsService.getById(id);
		if(referrals==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referrals,HttpStatus.FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Referrals> updateReferrals(@PathVariable("id") int id,@RequestBody ReferralsDtos referralsDtos){
		Referrals referrals=referralsService.getById(id);
		if(referrals==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referrals.setCreated_at(referralsDtos.getCreated_at());
		referrals.setDetails(referralsDtos.getDetails());
		referrals.setNote_type(referralsDtos.getNote_type());
		referrals.setReason(referralsDtos.getReason());
		
		
		Doctor doctor=doctorService.getById(referralsDtos.getDoctor_id());
		referrals.setDoctor_id(doctor);
		
		Patient patient=patientService.getById(referralsDtos.getPatient_id());
		referrals.setPatient_id(patient);
		
		Visit visit=visitService.getById(referralsDtos.getVisit_id());
		referrals.setVisit_id(visit);
		  
		ReferralCenter referralCenter=referralCenterService.getById(referralsDtos.getReferral_center_id());
		referrals.setReferral_center_id(referralCenter);
		
		Referrals updatedReferral=referralsService.save(referrals);
		
		return new ResponseEntity<>(updatedReferral,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
		Referrals referrals=referralsService.getById(id);
		if(referrals==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referralsService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	}
