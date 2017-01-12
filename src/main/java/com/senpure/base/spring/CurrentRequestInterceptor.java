package com.senpure.base.spring;


import com.senpure.base.util.Http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CurrentRequestInterceptor extends InterceptorSupport {
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		


	Http.setCurrentRequest(request);
	
		return true;
	}
	
	
	

	
	
}
