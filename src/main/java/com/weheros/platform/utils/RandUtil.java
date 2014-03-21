package com.weheros.platform.utils;


import java.text.DecimalFormat;
import java.util.Random;

public class RandUtil {
	
	private static Random rand = new Random();
	
	/**
	 * 鑾峰彇闅忔満楠岃瘉鐮侊紙鏁板瓧锛�
	 * 
	 * @author	leiyj
	 * @return
	 */
	public static String getRandCode() {
		int n = (int) Math.pow(10, 6);
		DecimalFormat df = new DecimalFormat("000000");
		return df.format(rand.nextInt(n));
	}
	
	/**
	 * 鑾峰彇闅忔満鏁�int
	 * 
	 * @author	leiyj
	 * @param 	i
	 * @return
	 */
	public static int nextInt(int i) {
		return rand.nextInt(i);
	}
	
	/**
	 * 鑾峰彇闅忔満鏁�double
	 * 
	 * @author	leiyj
	 * @return
	 */
	public static double nextDouble() {
		return rand.nextDouble();
	}
	
}
