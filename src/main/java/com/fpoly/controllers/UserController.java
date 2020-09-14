package com.fpoly.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fpoly.dtos.UserDto;
import com.fpoly.helper.JWTHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.fpoly.models.UserApplication;
import com.fpoly.services.UserService;

import javax.validation.Valid;

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
	public ResponseEntity signUp(@Valid @RequestBody UserDto newUser){
		if(!userService.existsById(newUser.getUsername())){
			UserApplication user = new UserApplication();
			BeanUtils.copyProperties(newUser, user);
			user.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			userService.save(user);
			return new ResponseEntity(HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/update")
	public ResponseEntity update(@Valid @RequestBody UserDto newUser, @RequestHeader("Authorization") String jwt) {
		Optional<UserApplication> optionalUser = userService.findById(newUser.getUsername());
		if(optionalUser.isPresent() && JWTHelper.getUsername(jwt).equals(optionalUser.get().getUsername())){
			UserApplication oldUser = optionalUser.get();
			oldUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			oldUser.setEmail(newUser.getEmail());
			userService.save(oldUser);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
