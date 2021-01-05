package com.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.dto.AddNewGheDTO;
import com.project.entity.Ghe;
import com.project.repository.GheRepository;

@Service
public class GheService {
	
	@Autowired
	private GheRepository gheRepository;
	
	public Object getAllGheByRapID(int id){
		List<Ghe> ghe = gheRepository.getAllGheByRapID(id);
		return ghe;
	}
	
	public Object addNewGhe(AddNewGheDTO addNewGheDTO) {
		ModelMapper mapper = new ModelMapper();
		Ghe ghe = mapper.map(addNewGheDTO, Ghe.class);
		try {
			int maxGhe_ID = gheRepository.maxGhe_ID();
			ghe.setMAGHE("MG" + (maxGhe_ID + 001));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ID null");
			ghe.setMAGHE("MG1");

		}
		gheRepository.save(ghe);
		return ghe;
	}
	
	public Object editGhe(AddNewGheDTO editGheDTO, int id) {
		ModelMapper modelMapper = new ModelMapper();
		Ghe ghe = modelMapper.map(editGheDTO, Ghe.class );
		ghe.setGHE_ID(id);
		ghe.setMAGHE(gheRepository.findMaGhe(id));
		gheRepository.save(ghe);
		return ghe;
		
	}
	public Object deleteGhe(@PathVariable int id) {
		
		if(gheRepository.findById(id)== null) {
			return "Ko tim thay id";
		}else {
			gheRepository.deleteById(id);
			return "Delete Complete";
		}
		
	}
	
	 
}
