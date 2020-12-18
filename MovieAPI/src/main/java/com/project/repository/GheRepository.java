package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Ghe;

public interface GheRepository extends JpaRepository<Ghe, Integer> {
	@Query("SELECT d FROM Ghe d WHERE d.RAP_ID = :id")
	List<Ghe> getAllGheByRapID(int id);
	
	@Query("SELECT MAX(d.GHE_ID) FROM Ghe d")
	int maxGhe_ID();
}
