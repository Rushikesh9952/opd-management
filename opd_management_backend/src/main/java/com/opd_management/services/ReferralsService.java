package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Referrals;

public interface ReferralsService {
	Referrals save(Referrals referrals);
	List<Referrals> getAllReferrals();
	Referrals getById(int id);
	void deleteById(int id);

}
