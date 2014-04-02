/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.front;

/**
 * @ClassName: ErrorCode
 * @author Administrator
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
	 ITEL_LENGTH_TOO_LONG("401","itel_length_too_long"),
	 THE_ITEL_NUMBER_IS_REPEAT("405","the_itel_number_is_repeat"),
	 THE_ITEL_NUMBER_IS_PRETTY("403","the_itel_number_is_pretty"),
	 THE_PHONE_NUMBER_IS_REPEAT("405","the_phone_number_is_repeat"),
	 
	 /*三次验证失败*/
	 THREE_TIMES_INPUT_ERROR("406","three_times_input_error"),
	 /*密保验证失败*/ 
	 SECURITY_VALIDATION_FAILED("407","security_validation_failed"),	
	 /*修改密码失败*/
	 CHANGE_THE_PASSWORD_FAILED("408","change_the_password_failed"),
	 /*设置密保失败*/ 
	 SET_PASSWORD_PROTECTION_FAILED("409","set_password_protection_failed"),	
	 /*修改密保失败*/
	 CHANGE_PASSWORD_PROTECTION_FAILED("410","change_password_protection_failed"),	
	 /*数据为空*/
	 DATA_IS_EMPTY("411","data_is_empty"),
	 /*重复添加好友*/
	 APPLY_ITEL_FRIEND_REPEAT("412","apply_itel_friend_repeat"),	
	 /*密码长度错误*/
	 PASSWORD_LENGTH_ERROR("413","password_length_error"),
	 /*输入数据不能为空*/
	 CANNOT_ENTER_EMPTY_STRING("414","cannot_enter_empty_string"),
	 /*号码不存在*/
	 NUMBER_DOES_NOT_EXIST("415","number_does_not_exist"),
	 /*没有设置密保问题*/
	 NOT_SET_SECURITY_QUESTION("222","not_set_security_question"),
	 /*已经是最新版本*/
	 IS_THE_LATEST_VERSION("201","is_the_latest_version"),
	 /*有新版本*/
	 THERE_IS_A_NEW_VERSION("202","there_is_a_new_version"),
	 /*版本号不存在或者类型错误*/
	 THE_VERSION_NUMBER_DOES_NOT_EXIT_OR_THE_WRONG_TYPE("416","the_version_number_does_not_exist_or_the_wrong_type"),
	
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
