/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.infrastructure.searchengine;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.core.CoreContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.weheros.platform.infrastructure.datasystem.nosql.InitializeApplicationDataAndParameters;


/**
 * 
 * @ClassName: SolrServerFactory
 * @Description: search engine construct factory.
 *               This is a spring bean configured in xml file.
 * @author Administrator
 * @date 2013年10月31日 下午2:55:15
 * 
 */
@Component("solrServerFactory")
public final class SolrServerFactory {
    
	protected static Logger log = LoggerFactory.getLogger(SolrServerFactory.class);

	 @Autowired
	static InitializeApplicationDataAndParameters initialization;

    public static SolrServer buildSolrServer(){    
    	String url=initialization.getAppconfig().getSolrServerPath();
    	return url.startsWith("http")?initHttpSolrServer(url):initEmbdSolrServer(url);
    }
    
    /**
     * 搜索引擎服务器,嵌入式
     */
    private static SolrServer solrServer = null;

    /**
     * solr核心容器
     */
    private static CoreContainer coreContainer = null;

    /**
     * 锁
     */
    private static final Lock lock = new ReentrantLock();

  

    /**
     * 关闭服务
     */
    public static void close() {    	
        if (null != coreContainer) {
            coreContainer.shutdown();
        }
    }   
    
    /**
     * 请注意，每次返回新的实例
     * @param url 
     * @param url 为空的时候，返回默认的相同的HttpSolrServer实例。
     * @return
     * @throws MalformedURLException 
     */
    private static SolrServer initHttpSolrServer(String url) {       
	    return new HttpSolrServer(url);
	
    }

    /**
     * 得到SolrServer实例
     * @param url 
     * 
     * @return
     */
    private static SolrServer initEmbdSolrServer(String url) {
        if (null == solrServer) {
            lock.lock();
            {
                if (null == solrServer) {
                    System.setProperty("solr.solr.home", url);
                    CoreContainer.Initializer initializer = new CoreContainer.Initializer();
                    //String solrconfig=SolrServerHelper.class.getResource("/conf/solrconfig.xml").toString().substring("file:/".length());
                   // initializer.setSolrConfigFilename(solrconfig);
                    try {
                        coreContainer = initializer.initialize();
                        coreContainer.setPersistent(true);
                        solrServer = new EmbeddedSolrServer(coreContainer, "");
                    } catch (IOException  | ParserConfigurationException | SAXException e) {
                        //e.printStackTrace();
                    	SolrServerFactory.log.error("initialize solr container with error.", e);
                    } 
                }
            }
            lock.unlock();
        }
        return solrServer;
    }
}
