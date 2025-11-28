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

import com.opd_management.dtos.VisitReportsDtos;
import com.opd_management.entities.Visit;
import com.opd_management.entities.VisitReports;
import com.opd_management.services.VisitReportsService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/visitreports")
public class VisitReportsController {
	
	@Autowired
	private VisitReportsService visitReportsService;
	
	@Autowired
	private VisitService visitService;
	
	@PostMapping("/")
	public ResponseEntity<VisitReports> save(@RequestBody VisitReportsDtos visitReportsDtos){
		VisitReports visitReports=new VisitReports();
		visitReports.setCreated_at(visitReportsDtos.getCreated_at());
		visitReports.setFile_name(visitReportsDtos.getFile_name());
		visitReports.setFile_type(visitReportsDtos.getFile_type());
		visitReports.setFile_url(visitReportsDtos.getFile_url());
		
		Visit visit=visitService.getById(visitReportsDtos.getVisit_id());
		visitReports.setVisit_id(visit);
		
		VisitReports saveVisitReports=visitReportsService.save(visitReports);
		return new ResponseEntity<>(saveVisitReports,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<VisitReports>> getAllVisitReports(){
		List<VisitReports> visitReports=visitReportsService.getAll();
		if(visitReports==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visitReports,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VisitReports> getById(@PathVariable("id") int id){
		VisitReports visitReports=visitReportsService.getById(id);
		if(visitReports==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visitReports,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VisitReports> updateVisitReports(@PathVariable("id") int id,@RequestBody VisitReportsDtos visitReportsDtos){
		VisitReports visitReports=new VisitReports();
		visitReports.setCreated_at(visitReportsDtos.getCreated_at());
		visitReports.setFile_name(visitReportsDtos.getFile_name());
		visitReports.setFile_type(visitReportsDtos.getFile_type());
		visitReports.setFile_url(visitReportsDtos.getFile_url());
		
		Visit visit=visitService.getById(visitReportsDtos.getVisit_id());
		visitReports.setVisit_id(visit);
		
		VisitReports updateVisitReports=visitReportsService.save(visitReports);

		return new ResponseEntity<>(updateVisitReports,HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
		VisitReports visitReports=visitReportsService.getById(id);
		if(visitReports==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visitReportsService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}

}
