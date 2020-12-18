package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AddUserDTO;
import com.project.entity.User;
import com.project.repository.UserRepository;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("api/user/findall")
	public Object findAllUser() {
		List<User> user = userRepository.findAll();
		if(user.isEmpty()) {
			return new ResponseEntity<String>("User Emty",HttpStatus.OK);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	@PostMapping("api/user/adduser")
	public Object addNewUSer(@Valid @RequestBody AddUserDTO addUserDTO, BindingResult errors) {
		
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(addUserDTO, User.class);
		int maxUser_ID = userRepository.maxUser_ID();
		
		if(errors.hasErrors()) {
			return new ResponseEntity(errors.getFieldError(), HttpStatus.BAD_REQUEST);
		}
		
		if(userRepository.findEmailDuplicate(addUserDTO.getEMAIL()) != null) {
			return new ResponseEntity<String>("Email đã được sử dụng!", HttpStatus.BAD_REQUEST);
		}
		if(userRepository.findUserNameDuplicate(addUserDTO.getUSERNAME()) != null) {
			return new ResponseEntity<String>("UserName đã được sử dụng!", HttpStatus.BAD_REQUEST);
		}
		if(userRepository.findSDTDuplicate(addUserDTO.getSDT()) != null) {
			return new ResponseEntity<String>("SDT đã được sử dụng!", HttpStatus.BAD_REQUEST);
		}
		
		user.setMAUSER("U" + (maxUser_ID + 001));
		 if(userRepository.save(user) != null) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	
		return new ResponseEntity<String>("Đã xảy ra lỗi vui lòng check lại!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("api/user/edituser/{USER_ID}")
	public Object editUser(@PathVariable("USER_ID") int USER_ID, @RequestBody AddUserDTO editUserDTO) {
		if(userRepository.findById(USER_ID) != null) {
			ModelMapper modelMapper = new ModelMapper();
			User user = modelMapper.map(editUserDTO, User.class);
			user.setUSER_ID(USER_ID);
			user.setMAUSER(user.getMAUSER());
			userRepository.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Lỗi", HttpStatus.BAD_REQUEST);
	}
	
}
