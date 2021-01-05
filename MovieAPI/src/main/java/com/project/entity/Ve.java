package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="VE")
public class Ve {
	@Id
	@GeneratedValue
	private int VE_ID;
	private String MAVE;
	private String TENVE;
	private String MAGHE;
	private Double GIAVE;
	private int TINHTRANGVE;
	
	private int USER_ID;
	
	private int LICHCHIEU_ID;
	
	@ManyToOne
	@JoinColumn(name ="LICHCHIEU_ID", insertable = false, updatable = false)
	private LichChieu lichchieu;
	
	@ManyToOne
	@JoinColumn(name ="USER_ID", insertable = false, updatable = false)
	private User user;
}
