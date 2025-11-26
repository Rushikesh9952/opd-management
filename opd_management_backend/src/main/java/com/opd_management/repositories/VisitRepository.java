package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Visit;
@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
