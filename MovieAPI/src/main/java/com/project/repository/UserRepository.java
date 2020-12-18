package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.dto.AddUserDTO;
import com.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT d FROM User d WHERE d.EMAIL = :EMAIL")
	 User findEmailDuplicate(@Param("EMAIL") String email);
	
	@Query("SELECT d FROM User d WHERE d.USERNAME = :USERNAME")
	User findUserNameDuplicate(@Param("USERNAME") String USERNAME);
	
	@Query("SELECT d FROM User d WHERE d.SDT = :SDT")
	User findSDTDuplicate(@Param("SDT") String SDT);
	
	@Query("SELECT d FROM User d WHERE d.USER_ID = :USER_ID")
	User findByMaUser(@Param("USER_ID") String USER_ID);
	
	@Query("SELECT MAX(d.USER_ID) FROM User d")
	int maxUser_ID();
	
	
}	
