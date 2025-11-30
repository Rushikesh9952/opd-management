package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class PathologyTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String result;
	private String remark;
	private String report_file;
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name="visit_Id")
	@JsonIgnoreProperties(value= {"visit_id"}, allowSetters=true)
	private Visit visit_id;
	
	@ManyToOne
	@JoinColumn(name="test_Id")
	@JsonIgnoreProperties(value= {"test_id"}, allowSetters=true)
	private TestMaster test_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReport_file() {
		return report_file;
	}

	public void setReport_file(String report_file) {
		this.report_file = report_file;
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

	public TestMaster getTest_id() {
		return test_id;
	}

	public void setTest_id(TestMaster test_id) {
		this.test_id = test_id;
	}

	public PathologyTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PathologyTest(int id, String result, String remark, String report_file, String created_at, Visit visit_id,
			TestMaster test_id) {
		super();
		this.id = id;
		this.result = result;
		this.remark = remark;
		this.report_file = report_file;
		this.created_at = created_at;
		this.visit_id = visit_id;
		this.test_id = test_id;
	}

	@Override
	public String toString() {
		return "PathologyTest [id=" + id + ", result=" + result + ", remark=" + remark + ", report_file=" + report_file
				+ ", created_at=" + created_at + ", visit_id=" + visit_id + ", test_id=" + test_id + "]";
	}
	
	
	
}
