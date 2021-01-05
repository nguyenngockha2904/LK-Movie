package com.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
@Table(name = "HETHONGRAP")
public class HeThongRap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int HETHONGRAP_ID;
	private String MAHETHONGRAP;
	private String TENHETHONGRAP;
	private String BIDANH;
	private String LOGO;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hethongrap")
	@JsonIgnore
	private Set<CumRap> cumrap;

}
