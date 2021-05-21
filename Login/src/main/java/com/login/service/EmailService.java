package com.login.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.entities.User;
import com.login.util.EmailHelper;
import com.login.util.GenerateOtpHelper;

@Service
public class EmailService {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailHelper emailHelper;

	public boolean sendEmailForOtp(String userEmail) throws MessagingException {
		User user = userService.getUserByUserEmail(userEmail);
		System.out.println(user + " : " + user.getUserOtp() + " : " + user.getUserOtpTime());
		GenerateOtpHelper generateOtpHelper = new GenerateOtpHelper();
		String otp = generateOtpHelper.generateOtp();
		System.out.println(otp);
		boolean updateOtp = userService.updateOtp(userEmail, otp);
		if (updateOtp) {

			boolean sent = emailHelper.sendEmail(otp, userEmail);
			if (!sent) {
//			throw 
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}
