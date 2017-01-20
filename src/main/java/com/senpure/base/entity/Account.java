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
}
