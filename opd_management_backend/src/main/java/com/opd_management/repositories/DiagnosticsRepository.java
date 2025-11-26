package com.opd_management.repositories;

import javax.tools.Diagnostic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Diagnostics;
@Repository
public interface DiagnosticsRepository extends JpaRepository<Diagnostics,Integer>{

}
