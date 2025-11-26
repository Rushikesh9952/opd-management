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

import com.opd_management.dtos.VisitDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.Visit;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController {
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/")
	public ResponseEntity<Visit> saveVisit(@RequestBody VisitDtos visitDtos){
		Visit visit=new Visit();
		
			Doctor doctor=doctorService.getById(visitDtos.getDoctor_id());
			visit.setDoctor_id(doctor);
			
			Patient patient=patientService.getById(visitDtos.getPatient_id());
			visit.setPatient_id(patient);
			
		 	visit.setVisit_date(visitDtos.getVisit_date());

		    visit.setComplaints(visitDtos.getComplaints());
		    visit.setDiagnosis(visitDtos.getDiagnosis());
		    visit.setAdvice(visitDtos.getAdvice());

		    visit.setBp(visitDtos.getBp());
		    visit.setPulse(visitDtos.getPulse());
		    visit.setSaturation(visitDtos.getSaturation());
		    visit.setTemperature(visitDtos.getTemperature());
		    visit.setRespiration_rate(visitDtos.getRespiration_rate());

		    visit.setSugar(visitDtos.getSugar());
		    visit.setFasting_sugar(visitDtos.getFasting_sugar());
		    visit.setPp_sugar(visitDtos.getPp_sugar());
		    visit.setRandom_sugar(visitDtos.getRandom_sugar());

		    visit.setUrea_creatinine(visitDtos.getUrea_creatinine());

		    visit.setPast_history(visitDtos.getPast_history());
		    visit.setCurrent_medication(visitDtos.getCurrent_medication());
		    visit.setAdditional_notes(visitDtos.getAdditional_notes());

		    visit.setWeight(visitDtos.getWeight());
		    visit.setEdema(visitDtos.getEdema());
		    visit.setPallor(visitDtos.getPallor());
		    visit.setJaundice(visitDtos.getJaundice());

		    visit.setCvs(visitDtos.getCvs());
		    visit.setRs(visitDtos.getRs());
		    visit.setPa(visitDtos.getPa());
		    visit.setCns(visitDtos.getCns());

		    visit.setHb(visitDtos.getHb());
		    visit.setEcg(visitDtos.getEcg());

		    visit.setFollowup_date(visitDtos.getFollowup_date());

		    visit.setCreated_at(visitDtos.getCreated_at());
		    visit.setUpdated_at(visitDtos.getUpdated_at());
		    
		    Visit saveVisit=visitService.save(visit);
		    
		    return new ResponseEntity<>(saveVisit,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit> getVisitById(@PathVariable("id") int id){
		Visit visit=visitService.getById(id);
		if(visit==null) {
			return new ResponseEntity<>(visit,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Visit>> getAllVisits(){
		List<Visit> visit=visitService.listOfVisit();
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit,HttpStatus.FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Visit> updateVisit(@PathVariable("id") int id,@RequestBody VisitDtos visitDtos){
		Visit visit=visitService.getById(id);
		
		Doctor doctor=doctorService.getById(visitDtos.getDoctor_id());
		visit.setDoctor_id(doctor);
		
		Patient patient=patientService.getById(visitDtos.getPatient_id());
		visit.setPatient_id(patient);
		
	 	visit.setVisit_date(visitDtos.getVisit_date());

	    visit.setComplaints(visitDtos.getComplaints());
	    visit.setDiagnosis(visitDtos.getDiagnosis());
	    visit.setAdvice(visitDtos.getAdvice());

	    visit.setBp(visitDtos.getBp());
	    visit.setPulse(visitDtos.getPulse());
	    visit.setSaturation(visitDtos.getSaturation());
	    visit.setTemperature(visitDtos.getTemperature());
	    visit.setRespiration_rate(visitDtos.getRespiration_rate());

	    visit.setSugar(visitDtos.getSugar());
	    visit.setFasting_sugar(visitDtos.getFasting_sugar());
	    visit.setPp_sugar(visitDtos.getPp_sugar());
	    visit.setRandom_sugar(visitDtos.getRandom_sugar());

	    visit.setUrea_creatinine(visitDtos.getUrea_creatinine());

	    visit.setPast_history(visitDtos.getPast_history());
	    visit.setCurrent_medication(visitDtos.getCurrent_medication());
	    visit.setAdditional_notes(visitDtos.getAdditional_notes());

	    visit.setWeight(visitDtos.getWeight());
	    visit.setEdema(visitDtos.getEdema());
	    visit.setPallor(visitDtos.getPallor());
	    visit.setJaundice(visitDtos.getJaundice());

	    visit.setCvs(visitDtos.getCvs());
	    visit.setRs(visitDtos.getRs());
	    visit.setPa(visitDtos.getPa());
	    visit.setCns(visitDtos.getCns());

	    visit.setHb(visitDtos.getHb());
	    visit.setEcg(visitDtos.getEcg());

	    visit.setFollowup_date(visitDtos.getFollowup_date());

	    visit.setCreated_at(visitDtos.getCreated_at());
	    visit.setUpdated_at(visitDtos.getUpdated_at());
		
	    Visit updateVisit=visitService.save(visit);
	    return new ResponseEntity<>(visit,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVisit(@PathVariable("id") int id){
		Visit visit=visitService.getById(id);
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visitService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	

}
