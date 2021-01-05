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
import com.project.dto.AddNewAdminDTO;
import com.project.service.AdminService;

@RestController
@RequestMapping("api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getAllAdmin")
	public Object getAllAdmin() {
		return ResponseEntity.ok(adminService.getAllAdmin());
	}
	
	@PostMapping("/addNewAdmin")
	public Object AddNewAdmin(@RequestBody AddNewAdminDTO addNewAdminDTO) {
		return ResponseEntity.ok(adminService.addNewAdmin(addNewAdminDTO));
	}
	@PutMapping("/editAdmin/{id}")
	public Object EditAdmin(@PathVariable int id, @RequestBody AddNewAdminDTO editAdminDTO ) {
		return ResponseEntity.ok(adminService.editAdmin(id, editAdminDTO));
	}
	@DeleteMapping("/deleteAdmin/{id}")
	public Object deleteAdmin(@PathVariable int id) {
		return ResponseEntity.ok(adminService.deleteAdmin(id));
	}
}
