package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.ReferralCenter;
import com.opd_management.entities.Referrals;
@Repository
public interface ReferralsRepository extends JpaRepository<Referrals, Integer> {

}
