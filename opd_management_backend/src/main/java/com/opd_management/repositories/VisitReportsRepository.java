package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.VisitReports;
@Repository
public interface VisitReportsRepository extends JpaRepository<VisitReports, Integer>{

}
