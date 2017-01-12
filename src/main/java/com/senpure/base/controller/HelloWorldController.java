package com.senpure.base.controller;

import com.senpure.base.spring.BaseController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/7.
 */

@Controller
public class HelloWorldController extends BaseController  implements InitializingBean{

    @RequestMapping("/")
    public String home() {

        log.debug("home  helloworld =====================================");


        return "/helloWorld";
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.debug("初始化 helloworld conroller");
    }
}
