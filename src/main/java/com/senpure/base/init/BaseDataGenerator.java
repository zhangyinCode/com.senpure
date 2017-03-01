package com.senpure.base.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/1.
 */
@Component
@Order(value = 2)
public class BaseDataGenerator implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger LOG = LogManager.getLogger(BaseDataGenerator.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LOG.debug("event===================================================================");

    }
}
