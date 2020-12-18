package com.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.AddNewRapDTO;
import com.project.entity.Rap;
import com.project.repository.RapRepository;

@Service
public class RapService {
	
	@Autowired
	RapRepository rapRepository;
	
	public Object getAllRap() {
		List<Rap> rap = rapRepository.findAll();
		if (rap.isEmpty()) {
			return "Rap emty";
		}
		
		return rap;
	}
	
	public Object addNewRap(@RequestBody AddNewRapDTO addNewRapDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Rap rap = modelMapper.map(addNewRapDTO, Rap.class );
		try {
			int maxRap_ID = rapRepository.maxRAP_ID();
			rap.setMARAP("MR" + (maxRap_ID + 001));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ID null");
			rap.setMARAP("MR1");

		}
		
		rapRepository.save(rap);
		return rap;
	}
	
	public Object editRap(@PathVariable int id, @RequestBody AddNewRapDTO editRapDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Rap rap = modelMapper.map(editRapDTO, Rap.class );
		try {
			rap.setCUMRAP_ID(id);
			rapRepository.save(rap);
			return rap;
		} catch (Exception e) {
			return "Ko tim thay ID rap";
		}
	}
	
	public Object deleteRap(@PathVariable int id) {
		if(rapRepository.existsById(id)) {
			rapRepository.deleteById(id);
			return "Delete Complete";
		}else {
			return "Delete Error";
		}
	}
}
