package com.senpure.base.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Administrator on 2017/2/7.
 */
public class BaseService {
    protected Logger log;
    public BaseService() {

        log= LogManager.getLogger(getClass());
    }
}
