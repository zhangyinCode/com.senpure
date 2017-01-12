package com.senpure.base.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Map;

//@Repository
public class Spring implements ApplicationContextAware {
	private static 	Logger log=LogManager.getLogger(Spring.class);
	private static AbstractApplicationContext act;

	private static final String[] DEFAULT_APPLICATION_CONTEXT = new String[] { "applicationContext.xml" ,"applicationContext-mvc.xml","applicationContext-dataSource.xml"};


	public static void start() {

	start(DEFAULT_APPLICATION_CONTEXT);
	}
	public static void start(String... name) {
		if (act == null) {
			log.debug("准备开启spring，开始扫描配置文件......");

			act = new ClassPathXmlApplicationContext(
					name);
			act.registerShutdownHook();// 不知道有什么用
			log.info("Spring启动成功...........");
		}
	}
	public static void close() {
		if (act != null) {

			act.close();

			log.info("Spring关闭成功...........");
		} else {
			log.warn("Spring 没有启动，不用关闭");
		}
	}

	public static void putBean(String name, Object bean) {

		act.getBeanFactory().registerSingleton(name, bean);
	}

	public static <T> T getBean(Class<T> type) {
	
		return act.getBean(type);
	}

	public static Object getBean(String name) {
	
		return act.getBean(name);
	}

	public static <T> Map<String, T> getBeansOfType(Class<T> type) {
	
		return act.getBeansOfType(type);
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		log.info("Spring 获取ApplicationContext上下文:applicationName:"+context.getApplicationName()+",displayName:"+context.getDisplayName()+",id:"+context.getId());
		act = (AbstractApplicationContext) context;

	}

}
