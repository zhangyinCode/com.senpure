package com.senpure.base.entity;

import com.senpure.AppConstant;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by DZ on 2016-06-28 13:58
 */
@Entity
@Table(name = AppConstant.DB_BASE_PREFIX + "_ACCOUNT_VALUE")
public class AccountValue extends IntEntity {
    private static final long serialVersionUID = 1068563978298321852L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;
    @Column(name = "accountKey",length = 24,nullable = false)
    private String key;
    @Column(name = "accountValue",length = 128,nullable = false)
    private String value;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
