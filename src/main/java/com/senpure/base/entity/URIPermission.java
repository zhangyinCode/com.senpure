package com.senpure.base.entity;

import com.senpure.AppConstant;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/2/7.
 */
@Entity
@Table(name = AppConstant.DB_BASE_PREFIX + "_URI_PERMISSION")
public class URIPermission extends IntEntity {

    @Column
    private String uriAndMethod;


    @ManyToOne
    @JoinColumn(name = "permissionName")
    private Permission permission;

    public String getUriAndMethod() {
        return uriAndMethod;
    }

    public void setUriAndMethod(String uriAndMethod) {
        this.uriAndMethod = uriAndMethod;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
