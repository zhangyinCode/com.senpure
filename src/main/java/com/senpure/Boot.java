package com.senpure;

import com.senpure.base.spring.BaseController;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Administrator on 2016/12/15.
 */


//@ImportResource(locations = "classpath:applicationContext-mvc.xml")
@SpringBootApplication
@RestController
public class Boot extends BaseController {
    @RequestMapping("/test")
    public String home() {

        log.debug("test home -------");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {

        //开启控制台颜色日志
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        SpringApplication.run(Boot.class, args);


    }
}
