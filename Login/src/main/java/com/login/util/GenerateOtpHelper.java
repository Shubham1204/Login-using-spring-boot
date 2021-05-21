package com.login.util;

public class GenerateOtpHelper {

	public String generateOtp() {
		int min = 100000;
	      int max = 999999;
	      int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
		return Integer.toString(randomNumber);
	}

}
