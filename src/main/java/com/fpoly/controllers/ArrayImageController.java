package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.UserApplication;
import com.fpoly.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ArrayImageController {

	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ArrayImageController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping
	public List<UserApplication> getUsers(){
		return (List<UserApplication>) userService.findAll();
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserApplication userApplication){
		userApplication.setPassword(bCryptPasswordEncoder.encode(userApplication.getPassword()));
		userService.save(userApplication);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/select")
	public List<UserApplication> selectAll() {
		List<UserApplication> users = (List<UserApplication>) userService.findAll();
		return users;
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserApplication userApplication) {
		userService.save(userApplication);
		return new ResponseEntity(HttpStatus.OK);
	}
}
