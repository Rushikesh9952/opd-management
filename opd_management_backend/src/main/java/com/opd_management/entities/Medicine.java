package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Medicines")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String medicine_name;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	@JsonIgnoreProperties(value= {"doctor_id"},allowSetters = true)
	private Doctor doctor_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(int id, String medicine_name, String type, Doctor doctor_id) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.type = type;
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", medicine_name=" + medicine_name + ", type=" + type + ", doctor_id=" + doctor_id
				+ "]";
	}
	

}
