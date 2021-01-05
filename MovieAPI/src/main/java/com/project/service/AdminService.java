package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.project.dto.AddNewAdminDTO;
import com.project.dto.AdminDetailsDto;
import com.project.entity.Admin;
import com.project.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Object getAllAdmin() {
		List<Admin> admin = adminRepository.findAll();
		if(admin.isEmpty()) {
			return "Admin null";
		}
		return admin;
	}
	
	public Object addNewAdmin(AddNewAdminDTO addNewAdminDTO) {
	
//		Admin admin = new Admin(
//				addNewAdminDTO.getADMIN_HOTEN(),
//				addNewAdminDTO.getADMIN_EMAIL(),
//				addNewAdminDTO.getADMIN_GIOITINH(),
//				addNewAdminDTO.getADMIN_USERNAME(),
//				addNewAdminDTO.getADMIN_PASSWORD(),
//				addNewAdminDTO.getADMIN_DIACHI(),
//				addNewAdminDTO.getADMIN_CMND(),
//				addNewAdminDTO.getADMIN_AVATAR(),
//				addNewAdminDTO.getADMIN_TINHTRANG(),
//				addNewAdminDTO.getADMIN_SDT(),
//				addNewAdminDTO.getADMIN_CHUCVU(),
//				addNewAdminDTO.getADMIN_NGAYSINH(),
//				addNewAdminDTO.getADMIN_ROLE()
//				);
		ModelMapper modelMapper = new ModelMapper();
		Admin admin = modelMapper.map(addNewAdminDTO, Admin.class);
		String hashed = BCrypt.hashpw(addNewAdminDTO.getADMIN_PASSWORD(), BCrypt.gensalt());
		admin.setADMIN_PASSWORD(hashed);
		admin.setADMIN_ROLE("ROLE_ADMIN");
		return adminRepository.save(admin);
	}
	
	public Object editAdmin(int id,AddNewAdminDTO editAdminDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Admin admin = modelMapper.map(editAdminDTO, Admin.class);
		admin.setADMIN_ID(id);
		adminRepository.save(admin);
		return admin;
	}
	
	public Object deleteAdmin(int id) {
		if(adminRepository.findById(id) == null) {
			return "Ko tim thay admin";
		}else {
		adminRepository.deleteById(id);
		return "Complete";
		}
	}
	

	public UserDetails loadUserByUsername(String usernameadmin) throws UsernameNotFoundException {
		Admin admin = adminRepository.findAdminByUserName(usernameadmin);

		// Nếu email gửi từ client lên không có trong database
		if (admin == null) {
			throw new UsernameNotFoundException("Email không tồn tại!");
		}
		String roleName = admin.getADMIN_ROLE();

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		// Tạo đối UserDetailsDto
		AdminDetailsDto adminDetailsDto = new AdminDetailsDto(admin.getADMIN_USERNAME(), admin.getADMIN_PASSWORD(), authorities);

		return adminDetailsDto;
	}

}
