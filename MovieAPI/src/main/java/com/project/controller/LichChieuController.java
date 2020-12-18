package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AddNewLichChieuDTO;
import com.project.entity.LichChieu;
import com.project.repository.LichChieuRepository;
import com.project.service.LichChieuService;

@RestController
@RequestMapping("api/lichchieu")
public class LichChieuController {
	
	@Autowired
	LichChieuRepository lichChieuRepository;
	@Autowired
	LichChieuService lichChieuService;
	
	@GetMapping("api/lichchieu/getAllLichChieu")
	public Object getAlLichChieu() {
		return ResponseEntity.ok(lichChieuService.getAllLichChieu());
	}

	@PostMapping("api/lichchieu/addNewLichChieu")
	public Object addNewLichChieu(@RequestBody AddNewLichChieuDTO addNewLichChieuDTO) {
		return ResponseEntity.ok(lichChieuService.addNewLichChieu(addNewLichChieuDTO));
	}
	
	@PutMapping("api/lichchieu/editLichChieu/{id}")
	public Object editLichChieu(@PathVariable int id,@RequestBody AddNewLichChieuDTO editLichChieuDTO) {
		return ResponseEntity.ok(lichChieuService.editLichChieu(id, editLichChieuDTO));
	}
	
}
