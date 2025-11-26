package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.ReferralCenter;

public interface ReferralCenterService {
	ReferralCenter save(ReferralCenter referralCenter);
	List<ReferralCenter> listOfReferralCenter();
	ReferralCenter getById(int id);
	void deleteReferralById(int id);
}
