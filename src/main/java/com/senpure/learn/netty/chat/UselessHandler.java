package com.senpure.learn.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Administrator on 2016/12/29.
 */
public class UselessHandler extends SimpleChannelInboundHandler<String> {

    private static  final Logger log= LogManager.getLogger(UselessHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }
}
