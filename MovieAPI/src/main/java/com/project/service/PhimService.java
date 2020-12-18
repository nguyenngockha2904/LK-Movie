package com.project.service;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dto.AddNewPhimDTO;
import com.project.entity.Phim;
import com.project.repository.PhimRepository;

// Handle Logic for API Phim
@Service
public class PhimService {
	 private static String UPLOADED_FOLDER = "F://temp//";
	 private static String UPLOADED_FOLDER_RESULT = "static/upload/";
	@Autowired
	PhimRepository phimRepository ;
	
	public Phim addNewPhim(@RequestBody AddNewPhimDTO addNewPhimDTO) {
		
		
		ModelMapper modelMapper = new ModelMapper();
		Phim phim = modelMapper.map(addNewPhimDTO, Phim.class );
		try {
			int maxPhim_ID = phimRepository.maxPHIM_ID();
			phim.setMAPHIM("MVC" + (maxPhim_ID + 001));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ID null");
			phim.setMAPHIM("MVC1");

		}
		
		phimRepository.save(phim);
		return phim;
		
	}
	public String UploadFile( @RequestParam MultipartFile file, HttpServletRequest request) {
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
					
					return UPLOADED_FOLDER_RESULT + file.getOriginalFilename();
					
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	public Object editPhim(@PathVariable int id, @RequestBody AddNewPhimDTO editPhim) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		Phim phim = modelMapper.map(editPhim, Phim.class );
		phim.setPHIM_ID(id);
		phim.setMAPHIM(phimRepository.findMaPhim(id));
		phimRepository.save(phim);
		return phim;
	}
}
