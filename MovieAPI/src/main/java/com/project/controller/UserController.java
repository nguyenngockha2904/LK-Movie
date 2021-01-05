package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/findall")
	public Object findAllUser() {
		List<User> user = userRepository.findAll();
		if(user.isEmpty()) {
			return new ResponseEntity<String>("User Emty",HttpStatus.OK);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	@PostMapping("/adduser")
	public Object addNewUSer(@Valid @RequestBody AddUserDTO addUserDTO, BindingResult errors) {
		
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(addUserDTO, User.class);
	
		// Mã hóa mật khẩu
		String hashed = BCrypt.hashpw(addUserDTO.getPASSWORD(), BCrypt.gensalt());
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
		try {
			int maxUser_ID = userRepository.maxUser_ID();
			user.setMAUSER("US" + (maxUser_ID + 001));
			user.setPASSWORD(hashed);
			user.setROLE("ROLE_USER");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ID null");
			user.setMAUSER("US1");
			user.setPASSWORD(hashed);
			user.setROLE("ROLE_USER");
		}
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	
		//return new ResponseEntity<String>("Đã xảy ra lỗi vui lòng check lại!", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/edituser/{USER_ID}")
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
