package com.senpure.base.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorSupport extends HandlerInterceptorAdapter{

	
	protected Logger log;
	

	public InterceptorSupport() {
		
		super();
		log= LogManager.getLogger(getClass());
		
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
}
