package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.PathologyTest;
import com.opd_management.repositories.PathologyTestRepository;
import com.opd_management.services.PathologyService;

@Repository
public class PathologyTestServiceIMPLs implements PathologyService {
	
	@Autowired
	private PathologyTestRepository pathologyTestRepository;
	@Override
	public List<PathologyTest> getAll() {
		// TODO Auto-generated method stub
		return pathologyTestRepository.findAll();
	}

	@Override
	public PathologyTest save(PathologyTest pathologyTest) {
		// TODO Auto-generated method stub
		return pathologyTestRepository.save(pathologyTest);
	}

	@Override
	public PathologyTest getById(int id) {
		// TODO Auto-generated method stub
		return pathologyTestRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		pathologyTestRepository.deleteById(id);
	}
	

}
