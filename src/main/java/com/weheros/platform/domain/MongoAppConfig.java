/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: MongoAppConfig 
 * @author Yang
 * @date 2013年11月27日 下午4:57:43
 */
@Document(collection = "appconfig")
public class MongoAppConfig {
	@Id
	private ObjectId id;
	/**
	#--------------------------------------------------------------------------------
	# FileSystemAccess
	# Now is FastDFS
	#-------------------------------------------------------------------------------
    */
	private String fileSystemAccess="local";

    /**
	#--------------------------------------------------------------------------------
	# Http or embd solr path
	#-------------------------------------------------------------------------------
    */
	private String solrServerPath="E:\\business\\eclipse\\workspace\\solrmaven\\src\\main\\resources";

    /**
	#--------------------------------------------------------------------------------
	# IM Server and stun server
	#-------------------------------------------------------------------------------
    */
	private String imServerIp="42.96.159.215"; //IM server porxy IP (old:110.45.2.34)
	private Integer imServerPort=9000;
	private String  stunServerIp="stunserver.org";
	
	/**
	  * 
	  *memcached服务器的IP地址和端口
	  *默认端口11211
	  *多个服务器IP:PORT IP:PORT
	  *
	 */
	private String memcachedIps="localhost:11211";
	
	public String getMemcachedIps() {
		return memcachedIps;
	}
	public ObjectId getId() {
		return id;
	}
	public String getFileSystemAccess() {
		return fileSystemAccess;
	}
	public String getSolrServerPath() {
		return solrServerPath;
	}
	public String getImServerIp() {
		return imServerIp;
	}
	public Integer getImServerPort() {
		return imServerPort;
	}
	public String getStunServerIp() {
		return stunServerIp;
	}
	
}
