/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */

package com.weheros.platform.security.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName: Authotication
 * @author Administrator
 * @date 2014年1月14日 下午4:01:28
 */
public class UserDetail implements Serializable {
	/**
	  * @Fields serialVersionUID 
	  */
		
	private static final long serialVersionUID = -4141848153626195826L;
	private String username;
	private String password;
	
	private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	private String type;
	private boolean isEnabled;

	public UserDetail() {

	}
	public UserDetail(String username, String password,String type) {
	
		this.username = username;
		this.password = password;		
		this.type=type;
		this.isEnabled = true;
	}

	public UserDetail(String username, String password,
			Collection<GrantedAuthority> authorities, String type,boolean isEnabled) {
		
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.type=type;
		this.isEnabled = isEnabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
