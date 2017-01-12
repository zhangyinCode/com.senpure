package com.senpure;


import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;

import java.util.Properties;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017/1/12.
 */
public class ColorConsole {

    public static void main(String[] args) {


      // Ansi.setEnabled(true);

      //  AnsiConsole.systemInstall();

        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
    String str=    AnsiOutput.toString(new Object[]{AnsiColor.GREEN, " :: Spring Boot :: ", AnsiColor.DEFAULT, 789, AnsiStyle.FAINT, 789});

        Properties properties = System.getProperties();
        properties.list(System.out);
        out.println(str);
    }
}
