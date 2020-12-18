package com.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private int ADMIN_CMND;
	private String ADMIN_AVATAR;
	private int ADMIN_TINHTRANG;
	private int ADMIN_SDT;
	private int ADMIN_CHUCVU;
	private String ADMIN_NGAYSINH;

}
