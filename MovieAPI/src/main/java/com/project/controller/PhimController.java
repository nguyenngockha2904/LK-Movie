package com.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.dto.AddNewPhimDTO;
import com.project.entity.Phim;
import com.project.repository.PhimRepository;
import com.project.service.PhimService;

@RestController
@RequestMapping("api/phim")
public class PhimController {
	
	@Autowired
	PhimRepository phimRepository;
	
	@Autowired
	PhimService phimService;
	
	@GetMapping("api/phim/findAllPhim")
	public Object findAllPhim() {
		List<Phim> listPhim = phimRepository.findAll();
		if(listPhim.isEmpty()) {
			return new ResponseEntity<String>("List Phim Rỗng", HttpStatus.OK);
		}
		return new ResponseEntity<List<Phim>>(listPhim, HttpStatus.OK);
	}	
	
	@PostMapping("api/phim/addNewPhim")
	public Object addNewPhim(@RequestBody AddNewPhimDTO addNewPhimDTO ) {
		return ResponseEntity.ok(phimService.addNewPhim(addNewPhimDTO));
		
	}
	
	@PutMapping("api/phim/editPhim/{id}")
	public Object editPhim(@PathVariable int id ,@RequestBody AddNewPhimDTO editPhim) {
		return ResponseEntity.ok(phimService.editPhim(id, editPhim));
		
	}
	
	
	 private static String UPLOADED_FOLDER = "F://temp//";
	 private static String UPLOADED_FOLDER_RESULT = "static/upload/";
	@PostMapping("api/phim/addBannerPhim")
	public Object UploadFile( @RequestParam MultipartFile file, HttpServletRequest request) {
		//Lay duong dan tuyet doi cua thu muc upload
				
				String path = request.getServletContext().getRealPath("/" + UPLOADED_FOLDER);
				try {
					File dir = new File(path);
					if(!dir.exists()) {
						dir.mkdirs(); //Neu thu muc chua co thi tao moi
					}
					//Luu file
					File pathFile = new File(path + file.getOriginalFilename());
					file.transferTo(pathFile);
					String pathh = UPLOADED_FOLDER_RESULT + file.getOriginalFilename();
					return pathh;
					
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	
}
