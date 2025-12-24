package com.opd_management.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BillDtos {
	
	@NotNull(message = "Consultation fee is required")
	@Min(value = 0, message = "Consultation fee cannot be negative")
	private int consultation_fee;
	
	@NotBlank(message = "Payment status is required")
	@Pattern(
	        regexp = "PAID|PARTIAL|PENDING",
	        message = "Payment status must be PAID, PARTIAL, or PENDING")
	private String payment_status;
	
	@NotBlank(message = "Payment mode is required")
    @Pattern(
        regexp = "CASH|UPI|CARD|ONLINE",
        message = "Payment mode must be CASH, UPI, CARD, or ONLINE"
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
	
	@NotNull(message = "Visit ID is required")
    @Min(value = 1, message = "Visit ID must be greater than 0")
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
