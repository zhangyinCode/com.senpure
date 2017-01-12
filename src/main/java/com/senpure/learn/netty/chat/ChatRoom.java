package com.senpure.learn.netty.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ChatRoom {


    public void userEnterRoom() {

    }

    public static void main(String[] args) {

        Logger log2 = LogManager.getLogger("jkl");

        org.apache.log4j.Logger log1 = GameLoggerUtil.getGameLogger(1423);

        log2.debug("log2");
        log2.error("log2.error");
        log1.debug("log1");
        log1.error("log1.error");

    }

}
