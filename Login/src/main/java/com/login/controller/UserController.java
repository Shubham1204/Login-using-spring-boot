package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.User;
import com.login.service.UserService;

@RestController
@RequestMapping("/authenticated/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping("/add")
//	@Transactional
//	public ResponseEntity<?> addUser(@RequestBody User user){
//		userService.addUser(user);
//		return ResponseEntity.ok("user added");
//	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getUsers(){
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/get/{uEmail}")
	public ResponseEntity<?> getUserByEmail(@PathVariable("uEmail") String userEmail){
		User user = userService.getUserByUserEmail(userEmail);
		return ResponseEntity.ok(user);
	}
}