package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Collection;
import com.fpoly.services.CollectionService;

@RestController
@RequestMapping("/collections")
public class CollectionController {

	private CollectionService collectionService;

	public CollectionController(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	@GetMapping("/")
	public List<Collection> getCollections(){
		return (List<Collection>) collectionService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody Collection collection) {
		collectionService.save(collection);
		return new ResponseEntity(HttpStatus.OK);
	}
}
