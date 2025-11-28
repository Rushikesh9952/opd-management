package com.opd_management.dtos;

public class BillDtos {
	private int consultation_fee;
	private String payment_status;
	private String payment_mode;
	private int concession;
	private int payment_amount;
	private int total_amount;
	private int pending_amount;
	private String created_at;
	private int visit_id;
	public int getConsultation_fee() {
		return consultation_fee;
	}
	public void setConsultation_fee(int consultation_fee) {
		this.consultation_fee = consultation_fee;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public int getConcession() {
		return concession;
	}
	public void setConcession(int concession) {
		this.concession = concession;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public int getPending_amount() {
		return pending_amount;
	}
	public void setPending_amount(int pending_amount) {
		this.pending_amount = pending_amount;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	
}
