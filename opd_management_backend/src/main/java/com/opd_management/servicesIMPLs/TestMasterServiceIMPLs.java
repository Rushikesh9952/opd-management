package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.TestMaster;
import com.opd_management.repositories.TestMasterRepository;
import com.opd_management.services.TestMasterService;
@Service
public class TestMasterServiceIMPLs implements TestMasterService {
	
	@Autowired
	private TestMasterRepository testMasterRepository;

	@Override
	public TestMaster save(TestMaster testMaster) {
		// TODO Auto-generated method stub
		return testMasterRepository.save(testMaster);
	}

	@Override
	public List<TestMaster> getAllTestMaster() {
		// TODO Auto-generated method stub
		return testMasterRepository.findAll();
	}

	@Override
	public TestMaster getByID(int id) {
		// TODO Auto-generated method stub
		return testMasterRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		testMasterRepository.deleteById(id);
	}
	
	

}
