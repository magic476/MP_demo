package com.wp.Utils;

import java.security.SecureRandom;
import java.util.Random;

public class CAPTCHAUtil {

	private static final String SYMBOLS = "0123456789";
	
	private static final Random RANDOM = new SecureRandom();
	
	public static String getCAPTCHA() {
		
		char[] nonceChars = new char[6];
		
		for (int index = 0; index < nonceChars.length; ++index) {
			nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
		}
		
		return new String(nonceChars);
	}
}
