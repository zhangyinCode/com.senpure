package com.senpure.base.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {
	private static final Logger log= LogManager.getLogger(ExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		log.error("捕获到异常",ex);
		//return new ModelAndView("error");
		return null;
	}

}
