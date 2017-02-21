package com.senpure.base.struct;

import com.senpure.base.vo.PermissionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public class LoginedAccount implements Serializable {
    private static final long serialVersionUID = 1347550701424356203L;
    private	Integer id;
    private	String account;
    private	String password;
    private long loginTime;
    private	long createTime;
    private String loginIP;

    private List<PermissionVo> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }
}
