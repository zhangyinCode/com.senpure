package com.senpure.base.dao;

import com.senpure.base.entity.Account;
import com.senpure.base.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/7.
 */
@Repository
public interface AccountDao extends JpaRepository<Account,Integer> {


    public  Permission findPermissionByName(String permissionName);

    public  Account findAccountByAccount(String account);
}
