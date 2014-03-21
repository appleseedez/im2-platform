/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.infrastructure.filesystem;


import org.apache.commons.fileupload.FileItemIterator;

/**
 * 文件系统访问通用接口
 * @ClassName: IFileSystemAccess 
 * @author Administrator
 * @date 2013年11月4日 下午2:14:52
 */
public interface IFileSystemAccess {
    /**
     *  传入上传文件的迭代集合，保存后返回文件的存放地址。
     *  <p>典型文件就是图片</p>
      * @author Administrator
      * @param fileIterator 文件流封装后对象
      * @param storePathPrefix 文件存放路径前缀,如http://www.itelland.com/public/
      * @return 
      * String
      *
     */
	public String fileStore(FileItemIterator fileIterator,String storePathPrefix);
	
	
}
