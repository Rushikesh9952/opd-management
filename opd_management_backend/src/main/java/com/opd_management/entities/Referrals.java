package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Referrals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String note_type;
	private String reason;
	private String details;
	private String created_at;
	@ManyToOne
	@JoinColumn(name="visit_Id")
	@JsonIgnoreProperties(value="{visit_id}",allowSetters = true)
	private Visit visit_id;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	@JsonIgnoreProperties(value="{doctor_id}",allowSetters = true)
	private Doctor doctor_id;
	
	@ManyToOne
	@JoinColumn(name="patient_Id")
	@JsonIgnoreProperties(value="{patient_id}",allowSetters = true)
	private Patient patient_id;
	
	@ManyToOne
	@JoinColumn(name="referral_center_Id")
	@JsonIgnoreProperties(value="{referral_center_id}",allowSetters = true)
	private ReferralCenter referral_center_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote_type() {
		return note_type;
	}

	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public ReferralCenter getReferral_center_id() {
		return referral_center_id;
	}

	public void setReferral_center_id(ReferralCenter referral_center_id) {
		this.referral_center_id = referral_center_id;
	}

	public Referrals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Referrals(int id, String note_type, String reason, String details, String created_at, Visit visit_id,
			Doctor doctor_id, Patient patient_id, ReferralCenter referral_center_id) {
		super();
		this.id = id;
		this.note_type = note_type;
		this.reason = reason;
		this.details = details;
		this.created_at = created_at;
		this.visit_id = visit_id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.referral_center_id = referral_center_id;
	}

	@Override
	public String toString() {
		return "Referrals [id=" + id + ", note_type=" + note_type + ", reason=" + reason + ", details=" + details
				+ ", created_at=" + created_at + ", visit_id=" + visit_id + ", doctor_id=" + doctor_id + ", patient_id="
				+ patient_id + ", referral_center_id=" + referral_center_id + "]";
	}
	
	
}
