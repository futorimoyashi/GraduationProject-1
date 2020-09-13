package com.fpoly.controllers;

import com.fpoly.helper.JWTHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fpoly.models.UserApplication;
import com.fpoly.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/select")
	public List<UserApplication> selectAll() {
		return userService.findAll();
	}

	@PostMapping("/signup")
	public ResponseEntity signUp(@RequestBody UserApplication newUser){
		if(!userService.existsById(newUser.getUsername())){
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			userService.save(newUser);
			return new ResponseEntity(HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/update")
	public ResponseEntity update(@RequestBody UserApplication newUser, @RequestHeader("Authorization") String jwt) {
		Optional<UserApplication> optionalUser = userService.findById(newUser.getUsername());
		UserApplication oldUser;
		if(optionalUser.isPresent() && JWTHelper.getUsername(jwt).equals(optionalUser.get().getUsername())){
			oldUser = optionalUser.get();
			oldUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			oldUser.setEmail(newUser.getEmail());
			userService.save(oldUser);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
