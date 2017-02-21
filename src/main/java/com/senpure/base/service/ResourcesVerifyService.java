package com.senpure.base.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/6.
 */
@Service
public class ResourcesVerifyService {


    private Map<String,ResourceVerifyService> serviceMap=new HashMap<>();

    public void regService(ResourceVerifyService service)
    {
        Assert.notNull(service.getName(), "name cannot be empty");
        Assert.isNull(serviceMap.get(service.getName()), "ResourceVerify[" + service.getName() + "] is existing !");

        serviceMap.put(service.getName(),service);
    }
    public boolean verify(String name, Serializable accountId,Serializable resourceId)
    {
        return  serviceMap.get(name).verify(accountId,resourceId);
    }
}
