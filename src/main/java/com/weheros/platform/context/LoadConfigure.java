/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.context;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: LoadConfigure
 * @author Administrator
 * @date 2014年3月28日 下午5:37:08
 */
public class LoadConfigure {
	private static final Lock lock = new ReentrantLock();
	private static ApplicationContext context = null;

	private static ApplicationContext load() {
		lock.lock();
		if (null == context) {
			context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		}
		lock.unlock();
        return context;
	}

	public static Object getObject(String name) {
		load();
		return context.getBean(name);
	}
}
