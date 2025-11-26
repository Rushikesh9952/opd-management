package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.ReferralCenter;
import com.opd_management.repositories.ReferralCenterRepository;
import com.opd_management.services.ReferralCenterService;

@Repository
public class ReferralCenterServiceIMPLs implements ReferralCenterService {

	@Autowired
	private ReferralCenterRepository referralCenterRepository;
	@Override
	public ReferralCenter save(ReferralCenter referralCenter) {
		// TODO Auto-generated method stub
		return referralCenterRepository.save(referralCenter);
	}

	@Override
	public List<ReferralCenter> listOfReferralCenter() {
		// TODO Auto-generated method stub
		return referralCenterRepository.findAll();
	}

	@Override
	public ReferralCenter getById(int id) {
		// TODO Auto-generated method stub
		return referralCenterRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteReferralById(int id) {
		// TODO Auto-generated method stub
		
		referralCenterRepository.deleteById(id);
		
	}
	
	
}
