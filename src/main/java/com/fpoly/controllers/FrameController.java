package com.fpoly.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.fpoly.models.Frame;
import com.fpoly.services.FrameService;

@RestController
@RequestMapping("/frames")
public class FrameController {

	private FrameService frameService;

	public FrameController(FrameService frameService) {
		this.frameService = frameService;
	}

	@GetMapping("/")
	public List<Frame> getFrames(){
		return (List<Frame>) frameService.findAll();
	}
	
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestBody Frame frame) {
		frameService.save(frame);
		return new ResponseEntity(HttpStatus.OK);
	}
}
