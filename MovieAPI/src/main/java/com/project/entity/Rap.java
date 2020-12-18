package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "RAP")
public class Rap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RAP_ID;
	private String MARAP;
	private String TENRAP;
	private int CUMRAP_ID;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rap")
	private List<LichChieu> lichchieu = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rap")
	private List<Ghe> ghe = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "CUMRAP_ID", insertable = false, updatable = false)
	@JsonIgnore
	private CumRap cumrap;
}