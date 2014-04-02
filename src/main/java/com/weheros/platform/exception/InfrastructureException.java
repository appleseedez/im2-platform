/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.exception;

/**
 * @ClassName: InfrastructureException 
 * @author Yang
 * @date 2013年11月4日 下午4:07:59
 */
public class InfrastructureException extends RuntimeException {

	/**
	  * @Fields serialVersionUID 
	  */		
	private static final long serialVersionUID = -8385752704069294543L;

	public InfrastructureException(String message) {
		super(message);
	}

	public InfrastructureException(String message, Throwable cause) {
		super(message, cause);
	}

	public InfrastructureException(Throwable cause) {
		super(cause);
	}
}
