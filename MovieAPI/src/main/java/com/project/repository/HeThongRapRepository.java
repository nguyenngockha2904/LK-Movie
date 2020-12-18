package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.HeThongRap;

public interface HeThongRapRepository extends JpaRepository<HeThongRap, Integer> {
	@Query("SELECT MAX(d.HETHONGRAP_ID) FROM HeThongRap d")
	int maxHeThongRap_ID();
	
	@Query("SELECT d.MAHETHONGRAP FROM HeThongRap d WHERE d.HETHONGRAP_ID = :HETHONGRAP_ID")
	String findHeThongRap(int HETHONGRAP_ID);
}
