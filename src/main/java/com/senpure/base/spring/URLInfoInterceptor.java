package com.senpure.base.spring;


import com.senpure.base.util.ThreadLocalContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 *跟踪访问的相关信息
 * 
 * @author 罗中正
 * @version 1.0
 */
public class URLInfoInterceptor extends InterceptorSupport {
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// log.debug("urlInforInerceptor:afterCompletion");
		super.afterCompletion(request, response, handler, ex);
		ThreadLocalContext context = ThreadLocalContext.getContext();
		long c = System.currentTimeMillis() - (long) context.get(key);
		if (c > 5000) {
			log.warn("请求：" + request.getRequestURI() + ",用时:" + c + "毫秒,请检查相关程序代码 ");
		} else {
			log.debug("请求：" + request.getRequestURI() + ",用时:" + c + "毫秒");
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if(log.isDebugEnabled()&& modelAndView != null)
		{	log.debug("{} > {}",request.getRequestURI(), modelAndView.getViewName());}
		if (log.isTraceEnabled() && modelAndView != null) {

			Map<String, Object> map = modelAndView.getModel();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				log.trace("key={}，value={} " ,key ,map.get(key));

			}
		}
	}

	private static String key = URLInfoInterceptor.class + ".time";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ThreadLocalContext.getContext().set(key, System.currentTimeMillis());
		log.debug("preHandle:{}" , request.getRequestURI());
		if (log.isTraceEnabled()) {

			Enumeration<String> e = request.getHeaderNames();
			StringBuilder sb = new StringBuilder();
			while (e.hasMoreElements()) {
				String key = e.nextElement();
				sb.append(key).append(":").append(request.getHeader(key)).append(",");
			}
			log.trace("header:{}" , sb.toString());
		}

		return true;
	}

}
