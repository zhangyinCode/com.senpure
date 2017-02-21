package com.senpure.base.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/2/6.
 */

public abstract class BaseResourceVerifyService implements ResourceVerifyService, InitializingBean {

    @Autowired
    private ResourcesVerifyService service;
    @Override
    public void afterPropertiesSet() throws Exception {
        service.regService(this);
    }
}
