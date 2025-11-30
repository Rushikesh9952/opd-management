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

import com.opd_management.dtos.PathologyTestDtos;
import com.opd_management.entities.PathologyTest;
import com.opd_management.entities.TestMaster;
import com.opd_management.entities.Visit;
import com.opd_management.services.PathologyService;
import com.opd_management.services.TestMasterService;
import com.opd_management.services.VisitService;
@RestController
@RequestMapping("/pathologytest")
public class PathologyTestController {
	
	@Autowired
	private PathologyService pathologyService;
	
	@Autowired
	private VisitService visitService;

	@Autowired
	private TestMasterService testMasterService;
	
	// Save new pathology test
	@PostMapping("/")
	public ResponseEntity<PathologyTest> save(@RequestBody PathologyTestDtos pathologyTestDtos){
		PathologyTest pathologyTest = new PathologyTest();
		
		pathologyTest.setCreated_at(pathologyTestDtos.getCreated_at());
		pathologyTest.setRemark(pathologyTestDtos.getRemark());
		pathologyTest.setReport_file(pathologyTestDtos.getReport_file());
		pathologyTest.setResult(pathologyTestDtos.getResult());
		
		Visit visit = visitService.getById(pathologyTestDtos.getVisit_id());
		pathologyTest.setVisit_id(visit);
		
		TestMaster testMaster = testMasterService.getByID(pathologyTestDtos.getTest_id());
		pathologyTest.setTest_id(testMaster);
		
		PathologyTest savePathology = pathologyService.save(pathologyTest);
		return new ResponseEntity<>(savePathology, HttpStatus.CREATED);
	}
	
	// Get all pathology tests
	@GetMapping("/")
	public ResponseEntity<List<PathologyTest>> getAllPathologyTest(){
		List<PathologyTest> pathologyTests = pathologyService.getAll();
		
		if(pathologyTests == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pathologyTests, HttpStatus.FOUND);
	}
	
	// Get pathology test by ID
	@GetMapping("{id}")
	public ResponseEntity<PathologyTest> getById(@PathVariable("id") int id){
		PathologyTest pathologyTest = pathologyService.getById(id);
		
		if(pathologyTest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pathologyTest, HttpStatus.FOUND);
	}
	
	// Update pathology test
	@PutMapping("/{id}")
	public ResponseEntity<PathologyTest> updatePathologyTest(@PathVariable("id") int id, @RequestBody PathologyTestDtos pathologyTestDtos){
		
		PathologyTest pathologyTest=pathologyService.getById(id);
		if(pathologyTest==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pathologyTest.setCreated_at(pathologyTestDtos.getCreated_at());
		pathologyTest.setRemark(pathologyTestDtos.getRemark());
		pathologyTest.setReport_file(pathologyTestDtos.getReport_file());
		pathologyTest.setResult(pathologyTestDtos.getResult());
		
		Visit visit = visitService.getById(pathologyTestDtos.getVisit_id());
		pathologyTest.setVisit_id(visit);
		
		TestMaster testMaster = testMasterService.getByID(pathologyTestDtos.getTest_id());
		pathologyTest.setTest_id(testMaster);
		
		PathologyTest updatePathology = pathologyService.save(pathologyTest);
		return new ResponseEntity<>(updatePathology, HttpStatus.ACCEPTED);
	}
	
	// Delete pathology test by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
		PathologyTest pathologyTest = pathologyService.getById(id);
		
		if(pathologyTest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		pathologyService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
