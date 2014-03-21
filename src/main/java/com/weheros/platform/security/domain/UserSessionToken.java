/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.security.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.code.ssm.api.CacheKeyMethod;

/**
 * @ClassName: UserSessionToken 
 * @author wb
 * @date 2014-2-21 下午2:17:06
 */
@Document(collection = "usersessiontoken")
public class UserSessionToken implements Serializable{
//	private static final long serialVersionUID = 7517080513591583073L;  
	@Id
	private ObjectId id;
    private String username;
    private String apptype;
    private String phonecode;
    private String onlymark;
    private String sessiontoken;
    
//    @CacheKeyMethod
//    public String cacheKey(){
//    	return this.username+this.apptype+this.onlymark;
//    }
    
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApptype() {
		return apptype;
	}
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	public String getPhonecode() {
		return phonecode;
	}
	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}
	public String getOnlymark() {
		return onlymark;
	}
	public void setOnlymark(String onlymark) {
		this.onlymark = onlymark;
	}
	public String getSessiontoken() {
		return sessiontoken;
	}

	public void setSessiontoken(String sessiontoken) {
		this.sessiontoken = sessiontoken;
	}
    
    
}
