package com.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.AddNewCumRapDTO;
import com.project.entity.CumRap;
import com.project.repository.CumRapRepository;

@Service
public class CumRapService {

	@Autowired
	CumRapRepository cumRapRepository;

	public Object getAllCumRap() {
		List<CumRap> cumRap = cumRapRepository.findAll();
		if (cumRap.size() >0) {
			return cumRap;		
		}
		return new ArrayList<CumRap>();
	}

	public Object addNewCumRap(@RequestBody AddNewCumRapDTO addNewCumRapDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CumRap cumRap = modelMapper.map(addNewCumRapDTO, CumRap.class);
		
		cumRapRepository.save(cumRap);
		return cumRap;
	}

	public Object editCumRap(@PathVariable int id, @RequestBody AddNewCumRapDTO editCumRapDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CumRap cumRap = modelMapper.map(editCumRapDTO, CumRap.class);
		cumRap.setCUMRAP_ID(id);
		cumRapRepository.save(cumRap);
		return cumRap;
	}
		
	public Object deleteCumRap(@PathVariable int id) {
		
		if(cumRapRepository.findById(id)== null) {
			return "Ko tim thay id";
		}else {
			cumRapRepository.deleteById(id);
			return "Delete Complete";
		}
		
	}
}
