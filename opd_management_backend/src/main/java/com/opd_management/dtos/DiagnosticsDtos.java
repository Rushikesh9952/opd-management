package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class DiagnosticsDtos {
	@NotNull(message = "Name is required")
	private String name;
	
	@NotNull(message = "Doctor ID is required")
    @Min(value = 1, message = "Doctor ID must be greater than 0")
	private int doctor_id;
	
	@NotNull(message = "Visit ID is required")
    @Min(value = 1, message = "Visit ID must be greater than 0")
	private int visit_id;
	
	@NotNull(message = "Datetime is required")
    @PastOrPresent(message = "Datetime cannot be in the future")
	private Date datetime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
