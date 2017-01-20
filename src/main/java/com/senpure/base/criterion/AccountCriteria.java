package com.senpure.base.criterion;

import org.hibernate.validator.constraints.Length;

/**
 * Created by DZ on 2016-07-25 16:55
 */
    public class AccountCriteria extends  Criteria {

    @Length(max=12,min=6,message="{username.length.error}")
    private String account ;
    @Length(min=6,max=12,message="{password.length.error}")
    private String password ;

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
}
