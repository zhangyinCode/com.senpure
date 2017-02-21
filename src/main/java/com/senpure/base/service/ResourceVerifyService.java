package com.senpure.base.service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/6.
 */

public  interface ResourceVerifyService {


    public  String getName();
    public  boolean verify(Serializable accountId,Serializable resourceId);
}
