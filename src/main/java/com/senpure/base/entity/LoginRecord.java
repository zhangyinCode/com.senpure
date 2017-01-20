package com.senpure.base.entity;

import com.senpure.AppConstant;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by DZ on 2016-07-02 14:04
 */

@Table(name = AppConstant.DB_BASE_PREFIX + "_LOGIN_RECORD")

public class LoginRecord extends IntEntity {
    private static final long serialVersionUID = -2351846848214229447L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;
    private long loginTime;
    private Date loginDate;
    private long logoutTime;
    private Date logoutDate;
    private int loginType;
    private String loginTypeStr;
    private int logoutType;
    private String logoutTypeStr;
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public long getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(long logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getLoginTypeStr() {
        return loginTypeStr;
    }

    public void setLoginTypeStr(String loginTypeStr) {
        this.loginTypeStr = loginTypeStr;
    }

    public int getLogoutType() {
        return logoutType;
    }

    public void setLogoutType(int logoutType) {
        this.logoutType = logoutType;
    }

    public String getLogoutTypeStr() {
        return logoutTypeStr;
    }

    public void setLogoutTypeStr(String logoutTypeStr) {
        this.logoutTypeStr = logoutTypeStr;
    }
}
