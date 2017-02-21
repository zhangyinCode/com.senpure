package com.senpure.base.entity;

import com.senpure.AppConstant;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 只记录账号信息相关信息<br>
 * Created by DZ on 2016-06-27 10:47
 */
@Entity
@Table(name = AppConstant.DB_BASE_PREFIX+"_ACCOUNT")
public class Account extends IntEntity {
    private static final long serialVersionUID = -3733641324319450846L;

    @OneToMany(mappedBy = "account")
    private List<AccountValue> accountValues;
    @Column(length = 24,nullable = false,unique = true)
    private String account;
    @Column(length = 24,nullable = false)
    private String password;
    @Column(nullable = false)
    private long createTime;
    @Column(nullable = false)
    private Date createDate;

    @Column
    private String name ;

    /**
     * 当前ip255.255.255.255
     */
    @Column(nullable = true, length = 64)
    private String ip;
    // 数字IP，只存一个最接近真实IP的数据
    @Column(nullable = true)
    private Long ipNumber;
    /**
     * 当前来源，火狐，360，手机等
     * */

    private String source;

    /**
     * 禁止登陆，有多种可能
     */
    private Long ban;
    private Long banExpiry;
    //没有当前推出时间，只要一退出，就是last的数据了
    private Long loginTime;
    private Boolean online;
    @Column(nullable = false, length = 32)
    private String accountState = AppConstant.ACCOUNT_STATE_CREATE;
    @Column(nullable = true, length = 32)
    private String loginType =AppConstant.LOGIN_TYPE_ACCOUNT;
    @Column(nullable = true, length = 32)
    private String client;
    @Column(nullable = true, length = 12)
    private String clientVersion;

    private Integer clientVersionNumber;

    @Column(nullable = true, length = 32)
    private String lastLogoutType ;
    private Long lastLoginTime;
    private Long lastLogoutTime;
    @Column(nullable = true, length = 64)
    private String lastLoginIp;
    private String lastLoginSource;
    @Column(nullable = true, length = 32)
    private String lastLoginType; ;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<AccountValue> getAccountValues() {
        return accountValues;
    }

    public void setAccountValues(List<AccountValue> accountValues) {
        this.accountValues = accountValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(Long ipNumber) {
        this.ipNumber = ipNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getBan() {
        return ban;
    }

    public void setBan(Long ban) {
        this.ban = ban;
    }

    public Long getBanExpiry() {
        return banExpiry;
    }

    public void setBanExpiry(Long banExpiry) {
        this.banExpiry = banExpiry;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Integer getClientVersionNumber() {
        return clientVersionNumber;
    }

    public void setClientVersionNumber(Integer clientVersionNumber) {
        this.clientVersionNumber = clientVersionNumber;
    }

    public String getLastLogoutType() {
        return lastLogoutType;
    }

    public void setLastLogoutType(String lastLogoutType) {
        this.lastLogoutType = lastLogoutType;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(Long lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginSource() {
        return lastLoginSource;
    }

    public void setLastLoginSource(String lastLoginSource) {
        this.lastLoginSource = lastLoginSource;
    }

    public String getLastLoginType() {
        return lastLoginType;
    }

    public void setLastLoginType(String lastLoginType) {
        this.lastLoginType = lastLoginType;
    }
}
