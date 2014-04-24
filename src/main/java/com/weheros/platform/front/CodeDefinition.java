/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.front;

/**
 * @ClassName: ErrorCode
 * @author Yang
 * @date 2013年11月22日 下午12:53:02
 */
public enum CodeDefinition {
	 //2xx 成功                     4xx 客户端错误                         5xx 服务端错误
	 LOGIN_SUCCESS("200","login_is_sucess"),
	 LOGIN_FAIL("400","action_is_fail"),
	 USER_OR_PASSWORD_INCORRECT("401","user_or_password_incorrect"),
	 VERIFICATION_CODE_INCORRECT("402","verification_code_incorrect"),	
	 BLACK_LIST_ALREADY_EXISTS("405","black_list_already_exists"),	
	 
	 /*******************************************注册**********************************************************/
	 THE_ITEL_NUMBER_IS_LEGITIMATE("200","the_itel_number_is_legitimate"),
	
	
	 SERVER_EXCEPTION("500","something_wrong_with_server");
	 
	 private final String code;
     private final String internationalMessageCode;
	 public String getCode() {
		return code;
	}
	public String getInternationalMessageCode() {
		return internationalMessageCode;
	}
	private CodeDefinition(String code, String internationalMessageCode) {
		this.code = code;
		this.internationalMessageCode = internationalMessageCode;
	}

     
}
