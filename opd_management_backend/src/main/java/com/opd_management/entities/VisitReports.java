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
@Table(name="visit_reports")
public class VisitReports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String file_name;
	private String file_type;
	private String file_url;
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name="visit_Id")
	@JsonIgnoreProperties(value= {"visit_id"},allowSetters = true)
	private Visit visit_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Visit getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(Visit visit_id) {
		this.visit_id = visit_id;
	}

	public VisitReports(int id, String file_name, String file_type, String file_url, String created_at,
			Visit visit_id) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.file_type = file_type;
		this.file_url = file_url;
		this.created_at = created_at;
		this.visit_id = visit_id;
	}

	public VisitReports() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VisitReports [id=" + id + ", file_name=" + file_name + ", file_type=" + file_type + ", file_url="
				+ file_url + ", created_at=" + created_at + ", visit_id=" + visit_id + "]";
	}
	
	
	
}
