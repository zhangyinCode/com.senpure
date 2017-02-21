package com.senpure.base.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/6.
 */
@Service
public class SomethingResourceVerifyService extends  BaseResourceVerifyService {
    @Override
    public String getName() {
        return "somethingResource";
    }

    @Override
    public boolean verify(Serializable accountId, Serializable resourceId) {
        return false;
    }
}
