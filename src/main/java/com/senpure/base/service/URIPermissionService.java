package com.senpure.base.service;

import com.senpure.base.entity.URIPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class URIPermissionService extends BaseService {
    @Autowired
    private  URIPermissionService service;
    public List<URIPermission> loadURIPermissions(String uriAndMethod)
    {

       return service.loadURIPermissions(uriAndMethod);


    }
}
