package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.CumRap;

public interface CumRapRepository extends JpaRepository<CumRap, Integer> {
	@Query("SELECT MAX(d.CUMRAP_ID) FROM CumRap d")
	int maxCumRap_ID();

}