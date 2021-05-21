package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.Right;
import com.login.service.RightService;

@RestController
@RequestMapping("/authenticated/rights")
@CrossOrigin("*")
public class RightController {

	@Autowired
	private RightService rightService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addRight(@RequestBody Right right){
		Right savedRight = rightService.addRight(right);
		return ResponseEntity.ok(savedRight);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getRights(){
		List<Right> rights = rightService.getRights();
		return ResponseEntity.ok(rights);
	}
}