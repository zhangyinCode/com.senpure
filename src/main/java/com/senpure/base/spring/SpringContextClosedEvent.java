package com.senpure.base.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Repository;

@Repository
public class SpringContextClosedEvent implements ApplicationListener<ContextClosedEvent> {
	private static Logger LOG = LogManager.getLogger(SpringContextClosedEvent.class);

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {

		LOG.info("SpringContextClosedEvent---------------------------------------------------------------------------");

		//LOG.trace("将缓存写入磁盘----------------------------");
	//	List<CacheManager> knownCacheManagers = CacheManager.ALL_CACHE_MANAGERS;

	//	LOG.debug("Shutting down " + knownCacheManagers.size() + " CacheManagers.");

	//	while (!(knownCacheManagers.isEmpty()))
	//		(CacheManager.ALL_CACHE_MANAGERS.get(0)).shutdown();
	}
}
