package com.project.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhimForm {
	
	private int PHIM_ID;
	private String MAPHIM;
	private String TENPHIM;
	private String BIDANH;
	private String MOTA;
	private String TRAILER;
	private String NGAYKHOICHIEU;
	private String HINHANH;
	private MultipartFile BANNER;
	private int DANHGIA;
}
