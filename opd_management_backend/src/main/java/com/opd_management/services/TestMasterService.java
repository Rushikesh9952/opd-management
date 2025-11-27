package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.TestMaster;

public interface TestMasterService {
		
	TestMaster save(TestMaster testMaster);
	List<TestMaster> getAllTestMaster();
	TestMaster getByID(int id);
	void deleteByID(int id);
}
