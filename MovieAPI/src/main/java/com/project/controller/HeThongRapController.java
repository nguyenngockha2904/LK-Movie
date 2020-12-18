package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AddNewHeThongRapDTO;
import com.project.repository.HeThongRapRepository;
import com.project.service.HeThongRapService;

@RestController
@RequestMapping("api/hethongrap")
public class HeThongRapController {
	@Autowired	
	private HeThongRapRepository heThongRapRepository;
	
	@Autowired	
	private HeThongRapService heThongRapService;
	
	@GetMapping("/getAllHeThongRap")
	public Object getAllHeThongRap() {
		return ResponseEntity.ok(heThongRapService.getAllHeThongRap());
	}
	
	@PostMapping("/addHeThongRap")
	public Object addNewHeThongRap(@RequestBody AddNewHeThongRapDTO addNewHeThongRapDTO) {
		return ResponseEntity.ok(heThongRapService.addNewHeThongRap(addNewHeThongRapDTO));
	}
	
	@PutMapping("/editHeThongRap/{id}")
	public Object editHeThongRap(@PathVariable int id, @RequestBody AddNewHeThongRapDTO editHeThongRapDTO) {
		return ResponseEntity.ok(heThongRapService.editHeThongRap(id, editHeThongRapDTO));
	}
	@DeleteMapping("/deleteHeThongRap/{id}")
	public Object deleteHeThongRap(@PathVariable int id) {
		return ResponseEntity.ok(heThongRapService.deleteHeThongRap(id));
	}
}
	