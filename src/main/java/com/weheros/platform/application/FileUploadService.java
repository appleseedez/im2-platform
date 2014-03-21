/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.application;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weheros.platform.infrastructure.filesystem.FileSystemAccessFactory;
import com.weheros.platform.utils.PathHelper;

/**
 * @ClassName: FileUploadService
 * @Description: 文件上传服务
 * @author Administrator
 * @date 2013年11月4日 下午5:08:58
 */
@Service("fileUploadService")
public class FileUploadService {
	@Autowired
	FileSystemAccessFactory factory;
	
	public void upload(HttpServletRequest request) {
		long maxSize = 2 * 1024 * 1024 * 1024 ;
		 ServletFileUpload upload = new ServletFileUpload();
		 upload.setSizeMax(maxSize);
		 
		FileItemIterator fileIterator=null;
		try {
			fileIterator = upload.getItemIterator(request);
		} catch (FileUploadException | IOException e) {
			throw new RuntimeException("getItemIterator error.",e);
		}
		
		factory.buildFileSystemAccess().fileStore(fileIterator, PathHelper.getAbsoluteServletPath(request));
		
	}

}
