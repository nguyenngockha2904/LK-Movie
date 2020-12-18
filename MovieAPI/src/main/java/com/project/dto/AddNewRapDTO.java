package com.project.dto;

import javax.persistence.Column;

import org.mapstruct.Mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Mapper
public class AddNewRapDTO {
	@Column(name = "TENRAP")
	private String TENRAP;
	@Column(name = "CUMRAP_ID")
	private int CUMRAP_ID;
}
