package com.senpure.base.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Repository;

@Repository
public class SpringContextStoppedEvent implements
		ApplicationListener<ContextStoppedEvent> {
	private static Logger LOG = LogManager.getLogger(SpringContextStoppedEvent.class);
	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		LOG.info("SpringContextStoppedEvent---------------------------------------------------------------------------");

	}

}
