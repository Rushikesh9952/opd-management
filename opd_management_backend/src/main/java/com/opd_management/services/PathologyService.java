package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.PathologyTest;

public interface PathologyService {
	List<PathologyTest> getAll();
	PathologyTest save(PathologyTest pathologyTest);
	PathologyTest getById(int id);
	void deleteById(int id);
}
