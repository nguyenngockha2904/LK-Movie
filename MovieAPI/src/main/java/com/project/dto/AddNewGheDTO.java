package com.project.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class AddNewGheDTO {
	private String TENGHE;
	private int TINHTRANG;
	private int LOAIGHE;
	private double GIAGHE;
	
	@Column(name = "RAP_ID")
	private int RAP_ID;
	
	
}
