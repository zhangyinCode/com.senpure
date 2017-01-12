package com.senpure.learn.netty.chat;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ByteProcessor;

import java.nio.charset.Charset;
import java.util.List;

public class MyLineBasedFrameDecoder extends ByteToMessageDecoder {
    private final int maxLength;
    private final boolean failFast;
    private final boolean stripDelimiter;
    private boolean discarding;
    private int discardedBytes;

    public MyLineBasedFrameDecoder(int maxLength) {
        this(maxLength, true, false);
    }

    public MyLineBasedFrameDecoder(int maxLength, boolean stripDelimiter, boolean failFast) {
        this.maxLength = maxLength;
        this.failFast = failFast;
        this.stripDelimiter = stripDelimiter;
    }

    protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = this.decode(ctx, in);
        if(decoded != null) {
            out.add(decoded);
        }

    }

    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        int eol = findEndOfLine(buffer);
        int length;
        int delimLength;
        if(!this.discarding) {
            if(eol >= 0) {
                delimLength = eol - buffer.readerIndex();
                int delimLength1 = buffer.getByte(eol) == 13?2:1;
                if(delimLength > this.maxLength) {
                    buffer.readerIndex(eol + delimLength1);
                    this.fail(ctx, delimLength);
                    return null;
                } else {
                    ByteBuf length1;
                    if(this.stripDelimiter) {
                        length1 = buffer.readRetainedSlice(delimLength);
                        buffer.skipBytes(delimLength1);
                    } else {
                        length1 = buffer.readRetainedSlice(delimLength + delimLength1);
                    }

                    System.out.println("return :"+ length1.toString(Charset.forName("utf-8")));
                    return length1;
                }
            } else {
                length = buffer.readableBytes();
                if(length > this.maxLength) {
                    this.discardedBytes = length;
                    buffer.readerIndex(buffer.writerIndex());
                    this.discarding = true;
                    if(this.failFast) {
                        this.fail(ctx, "over " + this.discardedBytes);
                    }
                }

                return null;
            }
        } else {
            if(eol >= 0) {
                length = this.discardedBytes + eol - buffer.readerIndex();
                delimLength = buffer.getByte(eol) == 13?2:1;
                buffer.readerIndex(eol + delimLength);
                this.discardedBytes = 0;
                this.discarding = false;
                if(!this.failFast) {
                    this.fail(ctx, length);
                }
            } else {
                this.discardedBytes += buffer.readableBytes();
                buffer.readerIndex(buffer.writerIndex());
            }

            return null;
        }
    }

    private void fail(ChannelHandlerContext ctx, int length) {
        this.fail(ctx, String.valueOf(length));
    }

    private void fail(ChannelHandlerContext ctx, String length) {
        ctx.fireExceptionCaught(new TooLongFrameException("frame length (" + length + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    private static int findEndOfLine(ByteBuf buffer) {
        int i = buffer.forEachByte(ByteProcessor.FIND_LF);
        if(i > 0 && buffer.getByte(i - 1) == 13) {
            --i;
        }

        return i;
    }
}
