/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */

package com.weheros.platform.security.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com.weheros.platform.log.LogService;

/**
 * @ClassName: SessionTokenService
 * @author Administrator
 * @date 2014年4月25日 下午6:04:32
 */
public class SessionService {

	public static void main(String[] arr) {
		for (int i = 0; i < 100; i++) {
			SessionService.generate();
		}
	}

	public static String generate() {
		byte[] result=null;
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();

			// get its digest
			MessageDigest sha = MessageDigest.getInstance("MD5");
			result = sha.digest(randomNum.getBytes());

			LogService.info(SessionService.class, "Random number: " + randomNum);
			
		} catch (NoSuchAlgorithmException ex) {
			LogService.error(SessionService.class, "", ex);
		}
		return  hexEncode(result);

	}

	private final static char hexDigits[] = { 'M', 'U', '&', '%', 'T', 'z',
			':', '*', 'A', 'k', '?', '#', 'f', '$', '~', '!' };

	private final static String hexEncode(byte[] input) {
		int j = input.length;
		char str[] = new char[j * 2];
		try {

			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = input[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

		} catch (Exception e) {
			LogService.error(SessionService.class, "", e);

		}

		return new String(str);
	}

}
