package com.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddUserDTO {
	
//	private String MAUSER;
	@NotBlank(message = "Vui lòng nhập UserName!")
	private String USERNAME;
	@NotBlank(message = "Vui lòng nhập mật khẩu!")
	private String PASSWORD;
	private String SDT;
	private String HOTEN;
	private String AVATAR;
	@Email(message = "Email ko đúng định dạng!")
	private String EMAIL;
	private int GIOITINH;

	
}
