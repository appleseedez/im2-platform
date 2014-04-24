/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/

package com.weheros.platform.front;

import java.io.Serializable;

/**
 * @ClassName: Message
 * 
 * @author Yang
 * @date 2013年11月4日 下午4:49:14
 */
public class Response implements Serializable {
	/**
	  * @Fields serialVersionUID 
	  */		
	private static final long serialVersionUID = 1281508350531320991L;
	private int ret=0;
	public static final int VISIT_SUCCESS=0;
	public static final int VISIT_FAIL=-1;
	
	private String code;
	private String msg;
	/**
	 * this maybe one object or a List.
	 */
	private Object data;

	public Response(int ret, String code, String msg, Object data) {
		super();
		this.ret = ret;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Response() {

	}

	public Response(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
