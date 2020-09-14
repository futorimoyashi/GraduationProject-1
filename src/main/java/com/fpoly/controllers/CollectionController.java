package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

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
		return collectionService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody Collection collection) {
		collectionService.save(collection);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Collection collection) {
		Optional<Collection> optColl = collectionService.findById(collection.getId());
		if(optColl.isPresent()) {
			Collection col = optColl.get();
			col.setName(collection.getName());
			col.setDescription(collection.getDescription());
			col.setDate(collection.getDate());
			col.setPublic(collection.isPublic());
			collectionService.save(col);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
