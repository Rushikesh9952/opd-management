package com.opd_management.dtos;

import java.sql.Date;

public class PatientDtos {

	private int doctor_id;
	private String patient_name;
	private int age;
	private String gender;
	private long mobileno;
	private String address;
	private String blood_group;
	private int height;
	private String smkoking;
	private String alcohol;
	private String tobacco;
	private Date created_id;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
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
	public String getSmkoking() {
		return smkoking;
	}
	public void setSmkoking(String smkoking) {
		this.smkoking = smkoking;
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
	
	
}
