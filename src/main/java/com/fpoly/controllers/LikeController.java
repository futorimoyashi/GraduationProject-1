package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Like;
import com.fpoly.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	@GetMapping
	public List<Like> getLikes(){
		return (List<Like>) likeService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody Like like) {
		likeService.save(like);
		return new ResponseEntity(HttpStatus.OK);
	}
}
