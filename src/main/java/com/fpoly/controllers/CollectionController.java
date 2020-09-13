package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Collection;
import com.fpoly.models.UserApplication;
import com.fpoly.services.CollectionService;
import com.fpoly.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

	private CollectionService collectionService;

	public CollectionController(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	@GetMapping("/")
	public List<Collection> getCollectionServices(){
		return (List<Collection>) collectionService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> update(@RequestBody Collection collection) {
		collectionService.save(collection);
		return new ResponseEntity(HttpStatus.OK);
	}
}
