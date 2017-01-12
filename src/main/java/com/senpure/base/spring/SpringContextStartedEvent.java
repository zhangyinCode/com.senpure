package com.senpure.base.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Repository;

@Repository
public class SpringContextStartedEvent implements
		ApplicationListener<ContextStartedEvent> {
	private static Logger LOG = LogManager.getLogger(SpringContextStartedEvent.class);
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		LOG.info("SpringContextStartedEvent---------------------------------------------------------------------------");

	}

}
