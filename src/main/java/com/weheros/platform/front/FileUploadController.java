/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weheros.platform.application.FileUploadService;

/**
 * @ClassName: FileUploadController
 * 文件上传接口层
 * @author Administrator
 * @date 2013年11月4日 下午4:47:13
 */
@Controller("fileUploadController")
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
    @RequestMapping("/uploadFile")
    public @ResponseBody Response uploadFile(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value="name", required=false, defaultValue="World") String name) {
      
    	
    	fileUploadService.upload(request);
    	return new Response("200","upload success.");
    }
}
