/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.weheros.platform.exception.JsonException;

/**
 * @ClassName: ToJson 
 * @author Administrator
 * @date 2013年11月20日 下午2:29:43
 */
public final class ToJson {
	private static final Logger LOG = Logger.getLogger(ToJson.class);
	
	public static String toJson(Object o){
		String json="";
		try {
			json= new ObjectMapper().writeValueAsString(o);
		} catch (Exception e) {
			LOG.error("convert object to json string fail.",e);
			throw new JsonException("convert object to json string fail.",e);
		}
		return json;
	}
	
	public static <T> Object toObject (String json,Class<T> aclass){
		ObjectMapper mapper = new ObjectMapper();
		Object need=null;
		try {
			need=mapper.readValue(json, aclass);
		} catch (IOException e) {
			LOG.error("convert json string to object fail.",e);
		    throw new JsonException("convert json string to object fail.",e);
		}
		return need;
	}
}
