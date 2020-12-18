package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
	@Query("SELECT MAX(d.PHIM_ID) FROM Phim d")
	int maxPHIM_ID();
	
	@Query("SELECT d.MAPHIM FROM Phim d WHERE d.PHIM_ID = :PHIM_ID")
	String findMaPhim(int PHIM_ID);
}
