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

import com.project.dto.AddNewRapDTO;
import com.project.service.RapService;

@RestController
@RequestMapping("api/rap")
public class RapController {
	
	@Autowired
	private RapService rapService;
	
	@GetMapping("/getAllRap")
	public Object getAllRap() {
		return ResponseEntity.ok(rapService.getAllRap());
	}
	
	@PostMapping("/addNewRap")
	public Object addNewRap(@RequestBody AddNewRapDTO addNewRapDTO) {
		return ResponseEntity.ok(rapService.addNewRap(addNewRapDTO));
	}
	
	@PutMapping("/editRap")
	public Object editRap(@PathVariable int id, @RequestBody AddNewRapDTO editRapDTO) {
		return ResponseEntity.ok(rapService.editRap(id, editRapDTO));
	}
	
	@DeleteMapping("/deleteRap")
	public Object deleteRap(@PathVariable int id) {
		return ResponseEntity.ok(rapService.deleteRap(id));
	}
}
