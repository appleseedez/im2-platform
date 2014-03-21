/** 
 * Copyright (c) 2013 hyhc,Inc. All Rights Reserved.
 */
package com.weheros.fastdfs.itel.fastdfs;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

import org.apache.commons.io.IOUtils;

import com.weheros.fastdfs.core.fastdfs.ClientGlobal;
import com.weheros.fastdfs.core.fastdfs.StorageServer;
import com.weheros.fastdfs.core.fastdfs.SupperStorageClient;
import com.weheros.fastdfs.core.fastdfs.TrackerClient;
import com.weheros.fastdfs.core.fastdfs.TrackerGroup;
import com.weheros.fastdfs.core.fastdfs.TrackerServer;
import com.weheros.fastdfs.core.fastdfs.common.MyException;

/**
 * @ClassName: FastDFSClient
 * @Description: TODO
 * @author wb
 * @date 2013-1-20 
 * 
 */
public class FastDFSClient
{
	 public static TrackerGroup trackerGroup()
	    {
	        ClientGlobal.setG_connect_timeout(Integer.parseInt("100000"));
	        ClientGlobal.setG_charset("UTF-8");
	        ClientGlobal.setG_anti_steal_token(Boolean.parseBoolean("false"));
	        ClientGlobal.setG_network_timeout(Integer.parseInt("300000"));
	        ClientGlobal.setG_secret_key("FastDFS1234567890");
	        ClientGlobal.setG_tracker_http_port(Integer.parseInt("8000"));
	        ClientGlobal.setG_tracker_group(
	        		new TrackerGroup(
	        				new InetSocketAddress[] {
	        						new InetSocketAddress(
	        								"115.28.21.131:22122".split(":")[0], Integer.parseInt("115.28.21.131:22122".split(":")[1])) }));
	        TrackerGroup trackerGroup = ClientGlobal.getG_tracker_group();
	        return trackerGroup;
	    }

	    public static TrackerClient trackerClient()
	    {
	        return new TrackerClient(trackerGroup());
	    }
	    
    public static String uploadFile(InputStream inputStream, String fileExtName) throws IOException, MyException
    {
		TrackerClient	trackerClient =trackerClient();
		TrackerServer trackerServer =trackerClient.getConnection();
		StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
		SupperStorageClient storageClient = new SupperStorageClient(trackerServer, storageServer);
        String filePath = storageClient.upload_file1(IOUtils.toByteArray(inputStream), fileExtName, null);

        if (storageServer != null)
        {
            storageServer.close();
        }
        if (trackerServer != null)
        {
            trackerServer.close();
        }
        return filePath;
    }
    
}
