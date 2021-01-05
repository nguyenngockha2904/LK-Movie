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

import com.project.dto.AddNewGheDTO;
import com.project.service.GheService;
import com.project.service.RapService;

@RestController
@RequestMapping("api/ghe")
public class GheController {
	
	@Autowired
	private GheService gheService;
	
	
	
	@GetMapping("/getAllGheByRapID/{id}")
	public Object getAllGheByRapID(@PathVariable("id") int id) {
		
		return ResponseEntity.ok(gheService.getAllGheByRapID(id));
	}
	
	@PostMapping("/addNewGhe")
	public Object addNewGhe(@RequestBody AddNewGheDTO addNewGheDTO) {
		return ResponseEntity.ok(gheService.addNewGhe(addNewGheDTO));
	}
	
	@PutMapping("/editGhe/{id}")
	public Object editGhe(@PathVariable int id, @RequestBody AddNewGheDTO editGheDTO) {
		return ResponseEntity.ok(gheService.editGhe(editGheDTO, id));
	}
	
	@DeleteMapping("/deleteGhe")
	public Object deleteGhe(@PathVariable int id) {
		return ResponseEntity.ok(gheService.deleteGhe(id));
	}
}
