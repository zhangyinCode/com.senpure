package com.senpure.learn.netty.chat;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
/**
 * 
 *TODO：并没什么卵用
 *@author  罗中正  
 *@version 1.0
 */
public class ConsoleAppenderOutAndErr extends ConsoleAppender {
	@Override
	public void append(LoggingEvent event) {
		if (event.getLevel().toInt() >= Level.WARN.toInt()) {
			setTarget(SYSTEM_ERR);
		} else {
			setTarget(SYSTEM_OUT);
		}
		activateOptions();
		super.append(event);
	}


}
