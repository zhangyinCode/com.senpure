package com.senpure.learn.netty.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;




/**
 * Created by Administrator on 2017/1/11.
 */
public class grepConsole {


    public static void main(String[] args) {


        Logger log= LogManager.getLogger(grepConsole.class);

        log.trace("你好hello world");
        log.debug("hello world");
        log.warn("hello world");
        log.error("hello world");
        log.fatal("hello world");

        String str3;    System.out.println("hello world");

        String str;
        String str2;



        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);

        str = AnsiOutput.toString(new Object[]{AnsiColor.GREEN, " :: Spring Boot :: ", AnsiColor.DEFAULT, "123455", AnsiStyle.FAINT, "abc"});

        log.debug(str);
       // p.println(AnsiOutput.toString(new Object[]{AnsiColor.GREEN, " :: Spring Boot :: ", AnsiColor.DEFAULT, "1234", AnsiStyle.FAINT, "abc"}));

        str2 = "\u001B[32m :: Spring Boot :: \u001B[0;39m";
//[32m :: Spring Boot :: [39m1234[2mabc[0;39m
        System.out.println(str2);

    }
}
