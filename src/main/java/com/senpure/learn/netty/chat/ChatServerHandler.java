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
package com.senpure.learn.netty.chat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.ByteProcessor;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


/**
 * Handler implementation for the echo server.
 */
@Sharable
public class ChatServerHandler extends ChannelInboundHandlerAdapter {
    private static int findEndOfLine(ByteBuf buffer) {
        int i = buffer.forEachByte(ByteProcessor.FIND_LF);
        if (i > 0 && buffer.getByte(i - 1) == 13) {
            --i;
        }

        return i;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {


        ByteBuf buffer = (ByteBuf) msg;
//        int end = findEndOfLine(buffer);
//
//        //数据长度
//        int dataLength = 0;
//        if (end >= 0) {
//
//            dataLength = end - buffer.readerIndex();
//            //换行符长度\r\n 或\n
//          int   dataLength2=buffer.getByte(end) == 13?2:1;
//            ByteBuf buffer1=buffer.readRetainedSlice(dataLength);
//            buffer.skipBytes(dataLength2);
//
//        }

        System.out.print("收到消息:");


        String message = buffer.toString(Charset.forName("utf-8"));
        System.out.println(message);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.

        System.out.println("出现异常");
        cause.printStackTrace();
        ctx.close();
    }

    public static void main(String[] args) {


        System.out.println((char) 13);
    }
}
