package com.senpure.base.service;

import com.senpure.base.dao.PermissionDao;
import com.senpure.base.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class PermissionService extends BaseService {

    private List<Permission> permissions;
    @Autowired
    private PermissionDao dao;

    @PostConstruct
    public void loadAll() {
        permissions = dao.findAll();
    }

    public Permission loadPermission(String permissionName) {

        return dao.findPermissionByName(permissionName);

    }

    public void syncPermissions(List<Permission> permissions) {


        List<Permission> newPermissions = new ArrayList<>();

        for (Permission p : permissions) {

            boolean notNew = false;
            for (Permission p2 : this.permissions) {

                if (p.getName().equals(p2.getName())) {
                    log.info("{}在数据库中存在，以数据库中的数据为准不做修改",p.getName());
                    notNew = true;
                    break;
                }

            }
            if (!notNew) {
                log.info("新增权限相关的检查{}",p);
                newPermissions.add(p);
            }

        }

        if (!newPermissions.isEmpty()) {
            dao.save(newPermissions);
        }

    }
}
