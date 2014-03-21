/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.security.domain;

/**
 * @ClassName: GrantedAuthority 
 * @author Administrator
 * @date 2014年1月14日 下午4:34:56
 */
public class GrantedAuthority {
    private String role;

	public GrantedAuthority(String role) {
		super();
		this.role = role;
	}
}
