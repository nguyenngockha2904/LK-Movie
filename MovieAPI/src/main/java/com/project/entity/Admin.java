package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ADMIN")
public class Admin {
	@Id
	@GeneratedValue
	private int ADMIN_ID;
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
	public Admin(String aDMIN_HOTEN, String aDMIN_EMAIL, int aDMIN_GIOITINH, String aDMIN_USERNAME,
			String aDMIN_PASSWORD, String aDMIN_DIACHI, String aDMIN_CMND, String aDMIN_AVATAR, int aDMIN_TINHTRANG,
			String aDMIN_SDT, int aDMIN_CHUCVU, String aDMIN_NGAYSINH, String aDMIN_ROLE) {
		super();
		ADMIN_HOTEN = aDMIN_HOTEN;
		ADMIN_EMAIL = aDMIN_EMAIL;
		ADMIN_GIOITINH = aDMIN_GIOITINH;
		ADMIN_USERNAME = aDMIN_USERNAME;
		ADMIN_PASSWORD = aDMIN_PASSWORD;
		ADMIN_DIACHI = aDMIN_DIACHI;
		ADMIN_CMND = aDMIN_CMND;
		ADMIN_AVATAR = aDMIN_AVATAR;
		ADMIN_TINHTRANG = aDMIN_TINHTRANG;
		ADMIN_SDT = aDMIN_SDT;
		ADMIN_CHUCVU = aDMIN_CHUCVU;
		ADMIN_NGAYSINH = aDMIN_NGAYSINH;
		ADMIN_ROLE = aDMIN_ROLE;
	}
	public Admin() {
		
	}
}
