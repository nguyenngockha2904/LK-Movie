package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Rap;

public interface RapRepository  extends JpaRepository<Rap, Integer>{
	@Query("SELECT MAX(d.RAP_ID) FROM Rap d")
	int maxRAP_ID();
	
	@Query("SELECT d.MARAP FROM Rap d WHERE d.RAP_ID = :RAP_ID")
	String findMaRAP(int RAP_ID);
	
	
}
