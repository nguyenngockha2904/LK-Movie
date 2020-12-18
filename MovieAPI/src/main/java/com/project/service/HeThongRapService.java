package com.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.AddNewHeThongRapDTO;
import com.project.entity.HeThongRap;
import com.project.repository.HeThongRapRepository;

@Service
public class HeThongRapService {

	@Autowired
	 HeThongRapRepository heThongRapRepository;

	public Object getAllHeThongRap() {
		List<HeThongRap> heThongRap = heThongRapRepository.findAll();
		return heThongRap;
	}

	public Object addNewHeThongRap(@RequestBody AddNewHeThongRapDTO addNewHeThongRapDTO) {

		ModelMapper modelMapper = new ModelMapper();
		HeThongRap heThongRap = modelMapper.map(addNewHeThongRapDTO, HeThongRap.class);
		try {
			int maxHeThongRap_ID = heThongRapRepository.maxHeThongRap_ID();
			heThongRap.setMAHETHONGRAP("MLC" + (maxHeThongRap_ID + 1));
		} catch (Exception e) {
			// TODO: handle exception
			heThongRap.setMAHETHONGRAP("MLC1");
		}

		heThongRapRepository.save(heThongRap);
		return heThongRap;

	}

	public Object editHeThongRap(@PathVariable int id, @RequestBody AddNewHeThongRapDTO editHeThongRapDTO) {
		ModelMapper modelMapper = new ModelMapper();
		HeThongRap heThongRap = modelMapper.map(editHeThongRapDTO, HeThongRap.class);
		heThongRap.setHETHONGRAP_ID(id);
		heThongRap.setMAHETHONGRAP(heThongRapRepository.findHeThongRap(id));
		heThongRapRepository.save(heThongRap);
		return heThongRap;
	}
	
	public Object deleteHeThongRap(@PathVariable int id) {
		if(heThongRapRepository.existsById(id)) {
		heThongRapRepository.deleteById(id);
		}else {
			return "Dont find ID";
		}
		return "Complete";
	}
}
