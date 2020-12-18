package com.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "CUMRAP")	
public class CumRap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CUMRAP_ID;
	@Column(name = "HETHONGRAP_ID")
	private int HETHONGRAP_ID;
	private String TENCUMRAP;
	private String BIDANH;
	private String LOGO;
	private String DIACHI;
		
	@ManyToOne
	@JoinColumn(name = "HETHONGRAP_ID", insertable = false, updatable = false)
	@JsonIgnore
	private HeThongRap hethongrap;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cumrap")
	private List<Rap> rap;
}
