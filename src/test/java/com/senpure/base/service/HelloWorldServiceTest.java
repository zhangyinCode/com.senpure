package com.senpure.base.service;

import com.senpure.Boot;
import com.senpure.SpringBootTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/1/16.
 */


public class HelloWorldServiceTest  extends  SpringBootTestSupport{

    @Autowired
    HelloWorldService service;
    @Test
    public void addOne() throws Exception {



log.debug("lalalallalalalal");
         service.addOne();


    }
    @Test
    public  void updateOne()
    {
        service.update(56);
    }

}