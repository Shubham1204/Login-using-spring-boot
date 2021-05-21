package com.login.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.User;
import com.login.service.EmailService;
import com.login.service.UserService;

@RestController
@CrossOrigin("*")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/register")
	@Transactional
	public ResponseEntity<?> registerUser(@RequestBody User user){
		userService.addUser(user);
		try {
			emailService.sendEmailForOtp(user.getUserEmail());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("user registered");
	}
}