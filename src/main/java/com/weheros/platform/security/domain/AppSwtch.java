/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.security.domain;

/**
 * @ClassName: AppSwtch 
 * @author Administrator
 * @date 2014-2-26 上午10:19:07
 */
public class AppSwtch {

	private String sessiontoken;
	private String type;
	private String phonecode;
	public String getSessiontoken() {
		return sessiontoken;
	}
	public void setSessiontoken(String sessiontoken) {
		this.sessiontoken = sessiontoken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhonecode() {
		return phonecode;
	}
	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}
	
	
}
