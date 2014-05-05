/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.infrastructure.datasystem.nosql;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.weheros.platform.domain.MongoAppConfig;

/**
 * @ClassName: InitializeApplicationDataAndParameters
 * @Description: 初始化数据或者参数。
 * 存入MongoDB
 * @author Yang
 * @date 2013年11月21日 下午4:42:47
 */
@Service
public class InitializeApplicationDataAndParameters {
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	@Qualifier("mongoDataAccessService")
	INoSQLDataAccess noSQLDataAccess;
    
	private static final Lock lock = new ReentrantLock();
	
		
	public MongoAppConfig getAppconfig() {
		MongoAppConfig appconfig=noSQLDataAccess.getMongoOps().findAll(MongoAppConfig.class).get(0);
		return appconfig;
	}

	@PostConstruct
	public void initializeAppConfigure(){
		lock.lock();
		long number=noSQLDataAccess.count(null, MongoAppConfig.class);
		//初始化动作
		if(number==0){
			log.info("-----------------------initializeAppConfigure-----------------------");
			MongoAppConfig config=new MongoAppConfig();
			noSQLDataAccess.insert(config);
		}
		lock.unlock();
		log.info("-----------------------initializeAppConfigure is complete!-----------------------");
		
	}

	
}
