package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Patient;
import com.opd_management.entities.Visit;

public interface VisitService {
	Visit save(Visit visit);
	List<Visit> listOfVisit();
	Visit getById(int id);
	void deleteById(int id);
}
