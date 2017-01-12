package com.senpure.base.util;

import java.util.HashMap;
import java.util.Map;


public class ThreadLocalContext {
	private static ThreadLocal<ThreadLocalContext> context = new ThreadLocal();

	public static ThreadLocalContext getContext() {
		ThreadLocalContext c = context.get();
		if (c == null) {
			c = new ThreadLocalContext();
			context.set(c);
		}
		return c;
	}

	private Map<String, Object> map = new HashMap();

	public Object get(String key) {
		return map.get(key);
	}

	public Object set(String key, Object value) {
		return map.put(key, value);
	}

	public Object remove(String key) {
		return map.remove(key);
	}

	
}
