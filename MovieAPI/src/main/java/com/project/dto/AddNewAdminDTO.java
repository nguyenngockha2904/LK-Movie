package com.project.dto;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class AddNewAdminDTO {

	private String ADMIN_HOTEN;
	private String ADMIN_EMAIL;
	private int ADMIN_GIOITINH;
	private String ADMIN_USERNAME;
	private String ADMIN_PASSWORD;
	private String ADMIN_DIACHI;
	private String ADMIN_CMND;
	private String ADMIN_AVATAR;
	private int ADMIN_TINHTRANG;
	private String ADMIN_SDT;
	private int ADMIN_CHUCVU;
	private String ADMIN_NGAYSINH;
	private String ADMIN_ROLE;
	
	
}
