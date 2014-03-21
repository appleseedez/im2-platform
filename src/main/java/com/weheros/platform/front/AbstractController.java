/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */

package com.weheros.platform.front;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.weheros.platform.utils.ToJson;

/**
 * @ClassName: AbstractController
 * @author Administrator
 * @date 2013年11月26日 下午4:39:09
 */
public abstract class AbstractController {
	protected  Logger log = Logger.getLogger(getClass());
	@Autowired
	MessageSource messageSource;
    /**
     *  构建国际化的message
      * @author Yang
      * @param definition 代码定义  @see CodeDefinition
      * @param message
      * @param valuses
      * @param request
      * @return 
      * Message
      *
     */
	public Message constructInternationalMessage(CodeDefinition definition, Message message,
			Object[] valuses, HttpServletRequest request) {
		Locale locale = RequestContextUtils.getLocale(request);
		String internationalation = messageSource.getMessage(definition.getInternationalMessageCode(),valuses, locale);
		message.setCode(definition.getCode());
		message.setMsg(internationalation);
		return message;
	}
	public String constructInternationalMessage(String key,Object[] valuses, HttpServletRequest request) {
		Locale locale = RequestContextUtils.getLocale(request);
		String internationalation = messageSource.getMessage(key,valuses, locale);
		return internationalation;
	}

	
}
