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

import com.opd_management.dtos.TestMasterDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.TestMaster;
import com.opd_management.services.DoctorService;
import com.opd_management.services.TestMasterService;

@RestController
@RequestMapping("/testmaster")
public class TestMasterController {
	
	@Autowired
	private TestMasterService testMasterService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<TestMaster> saveTestMaster(@RequestBody TestMasterDtos testMasterDtos){
		TestMaster testMaster=new TestMaster();
		testMaster.setTest_name(testMasterDtos.getTest_name());
		testMaster.setNormal_range(testMasterDtos.getNormal_range());
		testMaster.setTest_name(testMasterDtos.getTest_name());
		
		Doctor doctor=doctorService.getById(testMasterDtos.getDoctor_id());
		testMaster.setDoctor_id(doctor);
		
		TestMaster saveTestMaster=testMasterService.save(testMaster);
		return new ResponseEntity<>(saveTestMaster,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TestMaster>> getAllTestMaster(){
		List<TestMaster> testMasters=testMasterService.getAllTestMaster();
		if(testMasters==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(testMasters,HttpStatus.FOUND);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TestMaster> getByID(@PathVariable("id") int id){
		TestMaster testMaster=testMasterService.getByID(id);
		if(testMaster==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(testMaster,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TestMaster> updateTestMaster(@PathVariable("id") int id,@RequestBody TestMasterDtos testMasterDtos){
		TestMaster testMaster=testMasterService.getByID(id);
		testMaster.setTest_name(testMasterDtos.getTest_name());
		testMaster.setNormal_range(testMasterDtos.getNormal_range());
		testMaster.setTest_name(testMasterDtos.getTest_name());
		
		Doctor doctor=doctorService.getById(testMasterDtos.getDoctor_id());
		testMaster.setDoctor_id(doctor);
		
		TestMaster updatedTestMaster=testMasterService.save(testMaster);
		return new ResponseEntity<>(updatedTestMaster,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTestMaster(@PathVariable("id") int id){
		TestMaster testMaster =testMasterService.getByID(id);
		if(testMaster==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		testMasterService.deleteByID(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}

}
