package com.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name = "LICHCHIEU")
public class LichChieu {
	@Id
	@GeneratedValue
	private int LICHCHIEU_ID;
	private String MALICHCHIEU;
	private String THOIGIANBATDAUCHIEU;
	private String THOIGIANKETTHUC;	
	private Double HESOCHENHLECH;

	
	
	@OneToMany(mappedBy = "lichchieu", fetch = FetchType.LAZY)
	private Set<Ve> ve;
	
	
	private int RAP_ID;
	@ManyToOne
	@JoinColumn(name= "RAP_ID", insertable = false, updatable = false)
	private Rap rap;
	
	private int PHIM_ID;
	@ManyToOne
	@JoinColumn(name = "PHIM_ID", insertable = false, updatable = false)
	private Phim phim;
	
}
