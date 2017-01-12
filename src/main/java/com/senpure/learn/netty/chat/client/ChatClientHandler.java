/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.senpure.learn.netty.chat.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class ChatClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf firstMessage;

    /**
     * Creates a client-side handler.
     */
    public ChatClientHandler() {
        firstMessage = Unpooled.buffer(ChatClient.SIZE);
        for (int i = 0; i < firstMessage.capacity(); i ++) {
            firstMessage.writeByte((byte) i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws UnsupportedEncodingException {


        for (int i = 0; i < 100; i++) {
            ByteBuf bb = Unpooled.buffer();
            String str="hello"+i+"";
            bb.writeBytes(str.getBytes("utf-8"));

         //   bb.alloc()
            System.out.println("发送消息："+str);
            ctx.writeAndFlush(bb);
            if(i%8==0)
            {
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }







    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
       ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
