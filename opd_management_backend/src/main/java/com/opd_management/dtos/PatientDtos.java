package com.opd_management.dtos;

import java.sql.Date;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class PatientDtos {
	@NotNull(message = "doctor id is required")
	@Positive(message = "id must be positive")
	private int doctor_id;
	
	@NotNull(message = "patient name is required")
	private String patient_name;
	
	@NotNull(message = "age is required")
	@Min(value=0,message = "Age must be positive")
	@Max(value=130,message = "Age cannot exceed 120")
	private int age;
	
	@NotBlank(message = "gender is required")
	   @Pattern(regexp = "Male|Female|Other",
       message = "Gender must be Male, Female, or Other")
	private String gender;
	
	@NotNull(message = "mobile no is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	private String mobileno;
	
	@NotBlank(message = "message is required")
	private String address;
	
	@NotBlank(message = "blood group is required")
	private String blood_group;
	
	@NotNull(message = "height is required")
	private int height;
	
	@NotBlank(message = "smoking field is required")
	  @Pattern(regexp = "Yes|No", message = "Smoking must be Yes or No")
	private String smoking;
	
	  @NotBlank(message = "Alcohol field is required")
	    @Pattern(regexp = "Yes|No", message = "Alcohol must be Yes or No")
	private String alcohol;
	  

	  @NotBlank(message = "Tobacco field is required")
	 @Pattern(regexp = "Yes|No", message = "Tobacco must be Yes or No")
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
	
	
}
