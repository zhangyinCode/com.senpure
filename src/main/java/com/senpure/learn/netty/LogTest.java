package com.senpure.learn.netty;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.ansi.AnsiOutput;

/**
 * Created by Administrator on 2017/1/11.
 */
public class LogTest {
    public static void main(String[] args) {
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);

        Logger log4j = LogManager.getLogger(LogTest.class);

        log4j.trace("hello world ");
        log4j.debug("hello world ");
        log4j.info("hello world ");
        log4j.warn("hello world 2");
        log4j.error("hello world ");
        log4j.fatal("hello world ");


    }
}
