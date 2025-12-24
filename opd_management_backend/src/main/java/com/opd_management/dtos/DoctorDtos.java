package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorDtos {
	@NotBlank(message = "name is required")
	@Size(min=3,max=50,message = "name must be between 3 to 50 character")
	private String name;
	
	@NotBlank(message = "email is required")
	@Email(message = "enter valid email")
	private String email;
	
	@NotBlank(message = "password is required")
	@Size(min=4,message = "Password must be have at least 4 character")
	private String password;
	
	@NotBlank(message = "specialization is required")
	private String specialization;
	
	@NotBlank(message = "clinic name is required")
	private String clinic_name;
	
	@NotBlank(message = "address must be is required")
	private String address;
	
	@NotNull(message = "mobile no is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	private String mobno;
	
	@NotNull(message = "mobile no is required")
	private String token;
	
	private String status;
	private Date created_at;
	private Date updated_at;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
