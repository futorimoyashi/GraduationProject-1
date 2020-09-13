package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.ArrayImage;
import com.fpoly.services.ArrayImageService;

@RestController
@RequestMapping("/images")
public class ArrayImageController {

	private ArrayImageService arrayImageService;

	public ArrayImageController(ArrayImageService arrayImageService) {
		this.arrayImageService = arrayImageService;
	}

	@GetMapping("/")
	public List<ArrayImage> getImages(){
		return (List<ArrayImage>) arrayImageService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody ArrayImage arrayImage) {
		arrayImageService.save(arrayImage);
		return new ResponseEntity(HttpStatus.OK);
	}
}
