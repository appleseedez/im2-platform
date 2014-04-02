/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PathHelper
 * @author Yang
 * @date 2013年11月4日 下午4:28:09
 */
public final class PathHelper {
     private PathHelper(){
    	 
     }
     
     public static String getAbsoluteServletPath(HttpServletRequest request){
    	 return request.getServletContext().getRealPath("/");  
     }
}
