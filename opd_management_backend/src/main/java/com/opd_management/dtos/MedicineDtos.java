package com.opd_management.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MedicineDtos {
	   @NotBlank(message = "Medicine name is required")
	    private String medicine_name;

	    @NotBlank(message = "Medicine type is required")
	    private String type;

	    @NotNull(message = "Doctor ID is required")
	    @Min(value = 1, message = "Doctor ID must be greater than 0")
	    private int doctor_id;
	    
	
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
}
