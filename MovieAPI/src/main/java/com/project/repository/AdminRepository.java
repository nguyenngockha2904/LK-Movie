package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dto.AddNewAdminDTO;
import com.project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT MAX(d.ADMIN_ID) FROM Admin d")
	int maxAdmin_ID();

	@Query("SELECT d FROM Admin d WHERE ADMIN_USERNAME = :ADMIN_USERNAME")
	Admin findAdminByUserName(String ADMIN_USERNAME);
}
