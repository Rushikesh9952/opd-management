package com.opd_management.dtos;

public class ReferralsDtos {
	private String note_type;
	private String reason;
	private String details;
	private String created_at;
	private int doctor_id;
	private int visit_id;
	private int patient_id;
	private int referral_center_id;
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
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getReferral_center_id() {
		return referral_center_id;
	}
	public void setReferral_center_id(int referral_center_id) {
		this.referral_center_id = referral_center_id;
	}
	
	
}
