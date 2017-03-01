package com.senpure.base.service;

import com.senpure.SpringBootTestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

      //  Collections.shuffle();

    }
    @Test
    public  void updateOne()
    {
        service.update(56);
    }

}