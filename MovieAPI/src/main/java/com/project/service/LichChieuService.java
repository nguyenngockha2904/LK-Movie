package com.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.AddNewLichChieuDTO;
import com.project.entity.LichChieu;
import com.project.repository.LichChieuRepository;

@Service
public class LichChieuService {
	
	@Autowired
	LichChieuRepository lichChieuRepository;
	
	public Object getAllLichChieu() {
		List<LichChieu> lichChieu = lichChieuRepository.findAll();
		return lichChieu;
	}
	public Object addNewLichChieu(@RequestBody AddNewLichChieuDTO addNewLichChieuDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		LichChieu lichChieu = modelMapper.map(addNewLichChieuDTO, LichChieu.class);
		try {
			int maxLichChieu_ID = lichChieuRepository.maxLichChieu_ID();
			lichChieu.setMALICHCHIEU("MLC" + (maxLichChieu_ID + 1));
		} catch (Exception e) {
			// TODO: handle exception
			lichChieu.setMALICHCHIEU("MLC1");
		}
			
		lichChieuRepository.save(lichChieu);
		return lichChieu;
		
	}
	
	public Object editLichChieu(@PathVariable int id, @RequestBody AddNewLichChieuDTO editLichChieuDTO) {
		ModelMapper modelMapper = new ModelMapper();
		LichChieu lichChieu = modelMapper.map(editLichChieuDTO, LichChieu.class);
		lichChieu.setLICHCHIEU_ID(id);
		lichChieu.setMALICHCHIEU(lichChieuRepository.findMaLichChieu(id));
		lichChieuRepository.save(lichChieu);
		return lichChieu;
	}
}
