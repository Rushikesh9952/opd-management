package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Referrals;
import com.opd_management.repositories.ReferralsRepository;
import com.opd_management.services.ReferralsService;
@Service
public class ReferralsServiceIMPLs implements ReferralsService {
	@Autowired
	private ReferralsRepository referralsRepository;

	@Override
	public Referrals save(Referrals referrals) {
		// TODO Auto-generated method stub
		return referralsRepository.save(referrals);
	}

	@Override
	public List<Referrals> getAllReferrals() {
		// TODO Auto-generated method stub
		return referralsRepository.findAll();
	}

	@Override
	public Referrals getById(int id) {
		// TODO Auto-generated method stub
		return referralsRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		referralsRepository.deleteById(id);
	}

	
	
	

}
