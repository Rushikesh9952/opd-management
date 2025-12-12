package com.opd_management.entities;
import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String patient_name;
	private int age;
	private String gender;
	private String mobileno;
	private String address;
	private String blood_group;
	private int height;
	private String smoking;
	private String alcohol;
	private String tobacco;
	private Date created_id;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	@JsonIgnoreProperties(value= {"doctor_id"}, allowSetters=true)
	private Doctor doctor_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getTobacco() {
		return tobacco;
	}
	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}
	public Date getCreated_id() {
		return created_id;
	}
	public void setCreated_id(Date created_id) {
		this.created_id = created_id;
	}
	public Patient(int id, Doctor doctor_id, String patient_name, int age, String gender, String mobileno, String address,
			String blood_group, int height, String smoking, String alcohol, String tobacco, Date created_id) {
		super();
		this.id = id;
		this.doctor_id = doctor_id;
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.mobileno = mobileno;
		this.address = address;
		this.blood_group = blood_group;
		this.height = height;
		this.smoking = smoking;
		this.alcohol = alcohol;
		this.tobacco = tobacco;
		this.created_id = created_id;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

