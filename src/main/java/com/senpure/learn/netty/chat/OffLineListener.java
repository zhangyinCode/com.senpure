package com.senpure.learn.netty.chat;

import io.netty.channel.ChannelHandlerContext;

public interface OffLineListener {

	public void executeOffLine(ChannelHandlerContext ctx);
	
	public  String getOffLineListenerName();
	
}
