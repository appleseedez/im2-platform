/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.infrastructure.filesystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weheros.platform.infrastructure.datasystem.nosql.InitializeApplicationDataAndParameters;
/**
 * @ClassName: FileSystemAccessFactory
 * @Description: 构建filesystemaccess
 * @author Administrator
 * @date 2013年11月6日 下午2:59:48
 */
@Component
public class FileSystemAccessFactory {
	@Autowired	 
	InitializeApplicationDataAndParameters initialization;
	
	public IFileSystemAccess buildFileSystemAccess(){
		IFileSystemAccess filesystem=null;
		
		if("local".equals(initialization.getAppconfig().getFileSystemAccess())){
			filesystem=new LocalFileSystemAccess();
		}else{
			filesystem=new FastDFSFilesystemAccess();
		}
		
		return filesystem;
	}
	
}
