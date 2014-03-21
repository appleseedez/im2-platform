/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.infrastructure.filesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weheros.platform.exception.InfrastructureException;

/**
 * @ClassName: LocalFileSystemAccess
 * @author Administrator
 * @date 2013年11月4日 下午3:22:25
 */

class LocalFileSystemAccess implements IFileSystemAccess {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public String fileStore(FileItemIterator fileIterator,String storePathPrefix) {
		this.log.debug("-------the prefix path is----------------"+storePathPrefix);
		FileOutputStream outstream=null;
		FileChannel filechannel=null;
		String theStorePath="";
		try {
			while (fileIterator.hasNext()) {
				
				FileItemStream item = fileIterator.next();
					// 忽略其他不是文件域的所有表单信息
					if (!item.isFormField()) {
						String name = item.getName();
						log.debug("-------------File field " + name
								+ " with file name " + item.getName()
								+ " detected.-------------------");

							InputStream stream = item.openStream();					
                            String random=UUID.randomUUID().toString();
                            for(char achar:random.toCharArray()){
                            	theStorePath+=achar+"/";
                            }
                            this.log.debug("-------the really store file path is----------------"+storePathPrefix+theStorePath+name);
							outstream = new FileOutputStream(storePathPrefix+theStorePath+name);

							filechannel = outstream.getChannel();
							int index = 0;
							for (;;) {
								byte[] content = new byte[8192];
								int res = stream.read(content);// 从流中读取固定长度的byte[]
								if (res == -1) {
									break;
								}

								ByteBuffer contentBuffer = ByteBuffer.wrap(content);							
								filechannel.write(contentBuffer, index);// 一段一段写入
								index = index + res;

							}

							
					}
						
			}
		} catch (FileUploadException | IOException e) {
			log.error("upload file with error.",e);
			throw new InfrastructureException("upload file with error.",e);
		}finally{
			
			try {
				if (null != outstream) {
					outstream.close();
				}
				if (null != filechannel) {
					filechannel.close();
				}
			} catch (IOException e) {
				log.error("filechannel close error.", e);
				throw new InfrastructureException("filechannel or outstream close error.",e);
			}
			
		}
		return theStorePath;
	}

}
