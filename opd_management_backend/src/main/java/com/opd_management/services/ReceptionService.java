package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Reception;

public interface ReceptionService {
	Reception save(Reception reception);
	List<Reception> getAllReception();
	Reception getById(int id);
	void deleteById(int id);
}
