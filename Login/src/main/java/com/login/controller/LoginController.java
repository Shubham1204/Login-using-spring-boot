package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.entities.LoginRequestModel;
import com.login.entities.ResponseMessage;
import com.login.entities.User;
import com.login.service.UserService;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestModel loginRequestModel) {
//		System.out.println(loginRequestModel.getEmail() + " : " + loginRequestModel.getPassword());
		ResponseMessage responseMessage = new ResponseMessage();
		if(loginRequestModel.getEmail()==null || loginRequestModel.getPassword()==null || 
				loginRequestModel.getEmail()=="" || loginRequestModel.getPassword()==""){
			responseMessage.setMessage("pls enter username or password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
		}
		User user = userService.getUserByUserEmailAndUserPassword(loginRequestModel);
		if (user != null) {
			if(user.getUserStatus()=='P') {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("pls verify email first");
			}
			return ResponseEntity.ok(user);
		}
		else {
			responseMessage.setMessage("user is not authorized/user not registered");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMessage);
		}
	}
}