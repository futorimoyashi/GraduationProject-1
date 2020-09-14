package com.fpoly.controllers;

import com.fpoly.dtos.CommentDto;
import com.fpoly.helper.JWTHelper;
import com.fpoly.models.Collection;
import com.fpoly.models.UserApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Comment;
import com.fpoly.services.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/")
	public List<Comment> getComments(){
		return (List<Comment>) commentService.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity add(@Valid @RequestBody CommentDto commentDto, @RequestHeader("Authorization") String jwt) {
		Comment comment = new Comment();
		Collection col = new Collection(commentDto.getCollectionId());
		UserApplication user = new UserApplication(JWTHelper.getUsername(jwt));

		comment.setDate(new Date());
		comment.setCollection(col);
		comment.setUser(user);
		comment.setComment(commentDto.getComment());

		commentService.save(comment);

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity update(@PathVariable int id, @RequestBody CommentDto commentDto, @RequestHeader("Authorization") String jwt){
		Optional<Comment> optCmt = commentService.findById(id);
		if(optCmt.isPresent() && optCmt.get().getUser().getUsername().equals(JWTHelper.getUsername(jwt))){
			Comment cmt = optCmt.get();
			cmt.setComment(commentDto.getComment());
			commentService.save(cmt);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable int id, @RequestHeader("Authorization") String jwt){
		Optional<Comment> optCmt = commentService.findById(id);
		if(optCmt.isPresent() && optCmt.get().getUser().getUsername().equals(JWTHelper.getUsername(jwt))){
			commentService.delete(optCmt.get());
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
