package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Comment;
import com.fpoly.services.CommentService;

@RestController
@RequestMapping("/users")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/")
	public List<Comment> getComments(){
		return (List<Comment>) commentService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody Comment comment) {
		commentService.save(comment);
		return new ResponseEntity(HttpStatus.OK);
	}
}
