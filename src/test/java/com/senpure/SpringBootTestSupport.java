package com.senpure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/1/16.
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class)
public class SpringBootTestSupport {

    protected Logger log;

    public SpringBootTestSupport() {
        log= LogManager.getLogger(getClass());
    }
}
