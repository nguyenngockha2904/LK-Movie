package com.project.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {
	@NotBlank(message = "Vui lòng nhập UserName!")
	private String USERNAME;
	@NotBlank(message = "Vui lòng nhập mật khẩu!")
	private String PASSWORD;
	public LoginDTO(@NotBlank(message = "Vui lòng nhập UserName!") String uSERNAME,
			@NotBlank(message = "Vui lòng nhập mật khẩu!") String pASSWORD) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
	}
	public LoginDTO() {
		
	}
	
}
