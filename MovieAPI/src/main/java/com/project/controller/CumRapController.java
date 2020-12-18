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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.dto.AddNewCumRapDTO;
import com.project.service.CumRapService;

@RestController
@RequestMapping("api/cumrap")
public class CumRapController {

	@Autowired
	private CumRapService cumRapService;
	
	@GetMapping("/getAll")
	public Object getAllCumRap()  {
		return ResponseEntity.ok(cumRapService.getAllCumRap());
	}
	
	@PostMapping("/addNewCumRap")
	public Object addNewCumRap(@RequestBody AddNewCumRapDTO addNewCumRapDTO) {
		return ResponseEntity.ok(cumRapService.addNewCumRap(addNewCumRapDTO));
	}
	
	@PutMapping("/editCumRap/{id}")
	public Object editCumRap(@PathVariable("id") int id , @RequestBody AddNewCumRapDTO editCumRapDTO) {
		return ResponseEntity.ok(cumRapService.editCumRap(id, editCumRapDTO));
	}
	
	@DeleteMapping("/deleteCumRap")
	public Object deleteCumRap(@PathVariable int id) {
		return ResponseEntity.ok(cumRapService.deleteCumRap(id));
	}
}
