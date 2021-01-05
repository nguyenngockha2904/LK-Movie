package com.project.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.project.entity.User;
import com.project.repository.AdminRepository;
import com.project.repository.UserRepository;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	UserDetailsService _userDetailsService;
	
	@Autowired
	AdminRepository adminRepository;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
			UserDetailsService userDetailsService) {
		super(authenticationManager);
		_userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		// Lấy token từ header do người dùng gửi lên
		String tokenBearer = request.getHeader("Authorization");
		
		// Kiểm tra xem token có bắt đầu bằng Bearer hay không
		if(tokenBearer != null && tokenBearer.startsWith("Bearer ")) {
			// Xóa tiền tố (Bearer )
			String token = tokenBearer.replace("Bearer ", "");
			
			// Giải mã token để lấy thông tin (email)
			String username = Jwts
					.parser()
					.setSigningKey("123qwe!@#")
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			
			// Lấy thông tin user từ db
			
			UserDetails user = _userDetailsService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			// Gán thông tin vào Security Context
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		chain.doFilter(request, response);
		
	}
	
	
}
