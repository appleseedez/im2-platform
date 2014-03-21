/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.infrastructure.cachemanage;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weheros.platform.exception.InfrastructureException;
import com.weheros.platform.infrastructure.datasystem.InitializeApplicationDataAndParameters;

/**
 * @ClassName: MemcacheFactory 
 * @author Administrator
 * @date 2014年1月2日 上午11:04:08
 */
@Service("MemcacheFactory")
public class MemcacheFactory {
	private final static Logger log = Logger.getLogger(MemcacheFactory.class);
	private static final Lock lock = new ReentrantLock();
	private static MemcachedClientBuilder builder=null;

	
	@Autowired
	private InitializeApplicationDataAndParameters initialization;
	
	public static MemcachedClient getMemcachedClient(){
		MemcachedClient client=null;
		try {
			client= builder.build();
		} catch (IOException e) {
			log.error("---------build memcache client error--------------",e);
			throw new InfrastructureException("-build memcache client error",e);
		}
		return client;
	}
    
	@PostConstruct
	private void initializeMemcache(){
		//10.0.0.40:11211
		lock.lock();
		if(null!=builder){
			log.info("==================ONLY initialize memcache one time!============");
			String ips=initialization.getAppconfig().getMemcachedIps();
			builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(ips),new int[] { 1, 1});
			builder.setCommandFactory(new BinaryCommandFactory());// use binary protocol
			builder.setConnectionPoolSize(200);
		}
		
		lock.unlock();
	}
}
