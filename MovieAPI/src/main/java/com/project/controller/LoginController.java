package com.project.controller;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AdminLoginDTO;
import com.project.dto.LoginDTO;
import com.project.entity.Admin;
import com.project.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/login")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("")
	public Object login(@RequestBody AdminLoginDTO adminLoginDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Admin admin = modelMapper.map(adminLoginDTO, Admin.class);
		
		try {
			
			// Bước 1: Gọi hàm đăng nhập của Spring Security
			Authentication  authentication =  authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(admin.getADMIN_USERNAME(),admin.getADMIN_PASSWORD()));
	
			// Bước 2: Lưu thông tin đăng nhập vào Context
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			Date date = new Date();
			// Bước 3: Tạo token
			String token = Jwts	
					.builder()
					.setSubject(adminLoginDTO.getADMIN_USERNAME())
					.setIssuedAt(date)
					.setExpiration(new Date(System.currentTimeMillis() + 86000L))
					.signWith(SignatureAlgorithm.HS512, "123qwe!@#")
					.compact();
			
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Sai email hoặc mật khẩu!", HttpStatus.BAD_REQUEST);
	}
	

}
