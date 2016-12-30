package com.senpure.base.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseController {
    protected Logger log;
    public BaseController() {
        log= LogManager.getLogger(getClass());
    }
}
