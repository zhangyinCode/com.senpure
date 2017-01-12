package com.senpure.base.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.RequestHandledEvent;

@Repository
public class SpringRequestHandleEvent implements
		ApplicationListener<RequestHandledEvent> {
	private static Logger LOG = LogManager.getLogger(SpringRequestHandleEvent.class);
	@Override
	public void onApplicationEvent(RequestHandledEvent event) {
	
		LOG.info("SpringRequestHandleEvent---------------------------------------------------------------------------");

	}

}
