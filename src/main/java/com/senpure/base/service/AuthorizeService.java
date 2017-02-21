package com.senpure.base.service;

import com.senpure.base.criterion.LoginCriteria;
import com.senpure.base.dao.AccountDao;
import com.senpure.base.entity.Account;
import com.senpure.base.result.Result;
import com.senpure.base.result.ResultMap;
import com.senpure.base.struct.LoginedAccount;
import com.senpure.base.util.ConvertUtil;
import com.senpure.base.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class AuthorizeService extends  BaseService {

    @Autowired
private AccountDao accountDao;

    public AccountVo loadAccount(Integer id)
    {

        return ConvertUtil.convert( accountDao.findOne(id));
    }
    public ResultMap login(LoginCriteria criteria)
    {

         Account account= accountDao.findAccountByAccount(criteria.getAccount());
        if(account==null)
        {
            return  ResultMap.getResult(Result.ACCOUNT_NOT_EXIST);
        }

        if(!account.getPassword().equals(criteria.getPassword()))
        {
            return  ResultMap.getResult(Result.PASSWORD_INCORRECT);
        }
     long now =System.currentTimeMillis();
        account.setLoginTime(now);
        accountDao.save(account);
        LoginedAccount loginedAccount=new LoginedAccount();
        loginedAccount.setId(account.getId());
        loginedAccount.setAccount(account.getAccount());
        loginedAccount.setLoginIP(criteria.getLoginIP());
        loginedAccount.setLoginTime(now);
       return   ResultMap.getSuccessResult().put("account",loginedAccount);


    }

}
