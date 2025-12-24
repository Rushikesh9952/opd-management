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

import com.opd_management.dtos.MedicineDtos;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Medicine;
import com.opd_management.services.DoctorService;
import com.opd_management.services.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<Medicine> saveMedicine(@Valid @RequestBody MedicineDtos medicineDtos){
		Medicine medicine=new Medicine();
		medicine.setMedicine_name(medicineDtos.getMedicine_name());
		medicine.setType(medicineDtos.getType());
		
		Doctor doctor=doctorService.getById(medicineDtos.getDoctor_id());
		medicine.setDoctor_id(doctor);
		
		Medicine saveMedicine= medicineService.save(medicine);
		return new ResponseEntity<>(saveMedicine,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Medicine>> getAllMedicine(){
		List<Medicine> medicines=medicineService.listOfMedicines();
		if(medicines==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(medicines,HttpStatus.FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable("id") int id){
		Medicine medicines=medicineService.getById(id);
		if(medicines==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(medicines,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicine> updateMedicine(@Valid @PathVariable("id") int id,@RequestBody MedicineDtos medicineDtos){
		Medicine medicine=medicineService.getById(id);
		if(medicine==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		medicine.setMedicine_name(medicineDtos.getMedicine_name());
		medicine.setType(medicineDtos.getType());
		
		Doctor doctor=doctorService.getById(medicineDtos.getDoctor_id()); 
		medicine.setDoctor_id(doctor);
		
		Medicine updateMedicine= medicineService.save(medicine);
		return new ResponseEntity<>(updateMedicine,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteMedicineById(@PathVariable("id") int id){
		
		Medicine medicine=medicineService.getById(id);
		if(medicine==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		medicineService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	

}
