package com.senpure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/12/15.
 */


@EnableAutoConfiguration
@RestController
public class Boot {
    @RequestMapping("/")
  public   String home() {
        return "Hello World!";
    }
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Boot.class, args);
    }
}
