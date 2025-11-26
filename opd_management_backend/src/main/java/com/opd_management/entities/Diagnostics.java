package com.opd_management.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="diagnostics")
public class Diagnostics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="visit_Id")
	@JsonIgnoreProperties(value= {"visit_id"}, allowSetters=true)
	private Visit visit_id;
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	@JsonIgnoreProperties(value= {"doctor_id"},allowSetters=true)
	private Doctor doctor_id;
	
	private String name;
	private Date datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Visit getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(Visit visit_id) {
		this.visit_id = visit_id;
	}
	public Doctor getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Diagnostics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diagnostics(int id, Visit visit_id, Doctor doctor_id, String name, Date datetime) {
		super();
		this.id = id;
		this.visit_id = visit_id;
		this.doctor_id = doctor_id;
		this.name = name;
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Diagnostics [id=" + id + ", visit_id=" + visit_id + ", doctor_id=" + doctor_id + ", name=" + name
				+ ", datetime=" + datetime + "]";
	}
	
	
	
	
	
	

}
