package com.senpure.base.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Administrator on 2017/1/20.
 */
public class BaseConfiguration {

    protected Logger log;

    public BaseConfiguration() {
        log= LogManager.getLogger(getClass());
    }
}
