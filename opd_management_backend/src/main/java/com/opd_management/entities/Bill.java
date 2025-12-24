package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="bills")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "consultation fee is required")
	@Min(value = 0, message = "Consultation fee cannot be negative")
	private int consultation_fee;
	@NotBlank(message = "Payment status is required")
	@Pattern(
	    regexp = "PAID|UNPAID|PARTIAL",
	    message = "Payment status must be PAID, UNPAID or PARTIAL"
	)
	private String payment_status;
	@NotBlank(message = "payment mode is required")
	@Pattern(
		    regexp = "CASH|CARD|UPI|ONLINE",
		    message = "Payment mode must be CASH, CARD, UPI or ONLINE"
	)
	private String payment_mode;
	@NotNull(message = "Concession is required")
	@Min(value = 0, message = "Concession cannot be negative")
	private int concession;
	

	@NotNull(message = "Payment amount is required")
	@Min(value = 0, message = "Payment amount cannot be negative")
	private int payment_amount;
	
	@NotNull(message = "Total amount is required")
	@Min(value = 0, message = "Total amount cannot be negative")
	private int total_amount;
	
	@NotNull(message = "Pending amount is required")
	@Min(value = 0, message = "Pending amount cannot be negative")
	private int pending_amount;
	
	
	@NotBlank(message = "Created date is required")
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name="visit_Id")
	@JsonIgnoreProperties(value={"visit_id"},allowSetters = true)
	private Visit visit_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Visit getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(Visit visit_id) {
		this.visit_id = visit_id;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, int consultation_fee, String payment_status, String payment_mode, int concession,
			int payment_amount, int total_amount, int pending_amount, String created_at, Visit visit_id) {
		super();
		this.id = id;
		this.consultation_fee = consultation_fee;
		this.payment_status = payment_status;
		this.payment_mode = payment_mode;
		this.concession = concession;
		this.payment_amount = payment_amount;
		this.total_amount = total_amount;
		this.pending_amount = pending_amount;
		this.created_at = created_at;
		this.visit_id = visit_id;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consultation_fee=" + consultation_fee + ", payment_status=" + payment_status
				+ ", payment_mode=" + payment_mode + ", concession=" + concession + ", payment_amount=" + payment_amount
				+ ", total_amount=" + total_amount + ", pending_amount=" + pending_amount + ", created_at=" + created_at
				+ ", visit_id=" + visit_id + "]";
	}
	
	
	
	
}
