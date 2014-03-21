/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PathHelper
 * @Description: TODO
 * @author Administrator
 * @date 2013年11月4日 下午4:28:09
 */
public final class PathHelper {
     private PathHelper(){
    	 
     }
     
     public static String getAbsoluteServletPath(HttpServletRequest request){
    	 return request.getServletContext().getRealPath("/");  
     }
}
