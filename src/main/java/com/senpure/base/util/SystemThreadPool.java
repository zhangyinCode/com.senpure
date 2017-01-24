package com.senpure.base.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SystemThreadPool {

	public static final ExecutorService service = Executors.newCachedThreadPool();

	public static void execute(Runnable command) {
		service.execute(command);

	}
	
}
