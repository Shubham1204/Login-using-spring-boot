package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.UserRepository;
import com.login.entities.LoginRequestModel;
import com.login.entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String addUser(User user) {
		System.out.println(user);
		userRepository.saveUserQuery(user.getUserName(), user.getUserEmail(), user.getUserContact(),
				user.getUserPassword(), user.getUserStatus(), user.getUserOtp(), user.getUserOtpTime());
		userRepository.mapUserRole(user.getUserEmail(), user.getRole().getRoleName());
		return "user added";
	}

	public boolean updateOtp(String userEmail, String otp) {
		long currentTime = System.currentTimeMillis();
		Integer updateOtpAndTime = userRepository.updateOtpAndTime(userEmail, otp, currentTime);
		System.out.println("updateOtp : " + updateOtpAndTime);
		if (updateOtpAndTime > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateUserStatus(String userEmail) {
		Integer updateUserStatus = userRepository.updateUserStatus(userEmail);
		System.out.println("updateUserStatus : " + updateUserStatus);
		if (updateUserStatus > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	public User getUserByUserEmailAndUserPassword(LoginRequestModel loginRequestModel) {
		return userRepository.findByUserEmailAndUserPassword(loginRequestModel.getEmail(),
				loginRequestModel.getPassword());
	}
}
