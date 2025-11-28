package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.VisitReports;
import com.opd_management.repositories.VisitReportsRepository;
import com.opd_management.services.VisitReportsService;
@Service
public class VisitReportsServiceIMPLs implements VisitReportsService {
	
	@Autowired
	private VisitReportsRepository visitReportsRepository;

	@Override
	public VisitReports save(VisitReports visitReports) {
		// TODO Auto-generated method stub
		return visitReportsRepository.save(visitReports);
	}

	@Override
	public List<VisitReports> getAll() {
		// TODO Auto-generated method stub
		return visitReportsRepository.findAll();
	}

	@Override
	public VisitReports getById(int id) {
		// TODO Auto-generated method stub
		return visitReportsRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		visitReportsRepository.deleteById(id);
	}

}
