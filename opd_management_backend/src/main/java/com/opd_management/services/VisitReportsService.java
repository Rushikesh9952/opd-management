package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.VisitReports;

public interface VisitReportsService {
	VisitReports save(VisitReports visitReports);
	List<VisitReports> getAll();
	VisitReports getById(int id);
	void deleteById(int id);
}
