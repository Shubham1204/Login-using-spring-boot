package com.login.controller;

import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.LoginRequestModel;
import com.login.entities.User;
import com.login.service.EmailService;
import com.login.service.UserService;

@RestController
@CrossOrigin("*")
public class VerifyOtpController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;

	@PostMapping("/verify")
	@Transactional
	public ResponseEntity<?> login(@RequestBody LoginRequestModel loginRequestModel) {
//		System.out.println(loginRequestModel.getEmail() + " : " + loginRequestModel.getPassword());
		if(loginRequestModel.getEmail()==null || loginRequestModel.getEmail()=="" ){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("pls enter username or password");
		}
		User user = userService.getUserByUserEmail(loginRequestModel.getEmail());
		if (user != null) {
			if(user.getUserStatus()=='P') {
				long now = System.currentTimeMillis();
				long prev = Long.valueOf(user.getUserOtpTime()) + TimeUnit.MINUTES.toMillis(5);
//				System.out.println(Long.valueOf(user.getUserOtpTime()) + TimeUnit.MINUTES.toMillis(5));
//				System.out.println(user.getUserOtpTime());
//				System.out.println(now);
				if(prev<now) {
					// send email again
					try {
						emailService.sendEmailForOtp(user.getUserEmail());
					} catch (MessagingException e) {
						return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(e.getMessage());
					}
				}
				else {
					if(loginRequestModel.getOtp().equals(user.getUserOtp())) {						
					if(userService.updateUserStatus(user.getUserEmail())) {
//						user = userService.getUserByUserEmail(user.getUserEmail());
						return ResponseEntity.ok("user verified");
					}
					}
					else {
						return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("pls enter correct otp");
					}
//					System.out.println(now-prev);
				}
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("pls verify email first");
			}
			return ResponseEntity.ok("user already verified");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user is not authorized/user not registered");
		}
	}
}