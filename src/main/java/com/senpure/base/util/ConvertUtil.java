package com.senpure.base.util;

import com.senpure.base.entity.*;
import com.senpure.base.vo.*;

/**
 * Created by Administrator on 2017/2/7.
 */
public class ConvertUtil {
    public static AccountVo convert(Account entity) {
        AccountVo vo= new AccountVo();
        return convert(entity,vo);
    }

    public static AccountVo convert(Account entity,AccountVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        vo.setAccount(entity.getAccount());
        vo.setPassword(entity.getPassword());
        vo.setCreateTime(entity.getCreateTime());
        vo.setCreateDate(entity.getCreateDate());
        vo.setName(entity.getName());
        vo.setIp(entity.getIp());
        vo.setIpNumber(entity.getIpNumber());
        vo.setSource(entity.getSource());
        vo.setBan(entity.getBan());
        vo.setBanExpiry(entity.getBanExpiry());
        vo.setLoginTime(entity.getLoginTime());
        vo.setOnline(entity.getOnline());
        vo.setAccountState(entity.getAccountState());
        vo.setLoginType(entity.getLoginType());
        vo.setClient(entity.getClient());
        vo.setClientVersion(entity.getClientVersion());
        vo.setClientVersionNumber(entity.getClientVersionNumber());
        vo.setLastLogoutType(entity.getLastLogoutType());
        vo.setLastLoginTime(entity.getLastLoginTime());
        vo.setLastLogoutTime(entity.getLastLogoutTime());
        vo.setLastLoginIp(entity.getLastLoginIp());
        vo.setLastLoginSource(entity.getLastLoginSource());
        vo.setLastLoginType(entity.getLastLoginType());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static Account convert(AccountVo vo) {
        Account entity= new Account();
        return convert(vo,entity);
    }

    public static Account convert(AccountVo vo,Account entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        if(vo.getAccount()!=null){
            entity.setAccount(vo.getAccount());
        }
        if(vo.getPassword()!=null){
            entity.setPassword(vo.getPassword());
        }
        entity.setCreateTime(vo.getCreateTime());
        if(vo.getCreateDate()!=null){
            entity.setCreateDate(vo.getCreateDate());
        }
        if(vo.getName()!=null){
            entity.setName(vo.getName());
        }
        if(vo.getIp()!=null){
            entity.setIp(vo.getIp());
        }
        if(vo.getIpNumber()!=null){
            entity.setIpNumber(vo.getIpNumber());
        }
        if(vo.getSource()!=null){
            entity.setSource(vo.getSource());
        }
        if(vo.getBan()!=null){
            entity.setBan(vo.getBan());
        }
        if(vo.getBanExpiry()!=null){
            entity.setBanExpiry(vo.getBanExpiry());
        }
        if(vo.getLoginTime()!=null){
            entity.setLoginTime(vo.getLoginTime());
        }
        if(vo.isOnline()!=null){
            entity.setOnline(vo.isOnline());
        }
        if(vo.getAccountState()!=null){
            entity.setAccountState(vo.getAccountState());
        }
        if(vo.getLoginType()!=null){
            entity.setLoginType(vo.getLoginType());
        }
        if(vo.getClient()!=null){
            entity.setClient(vo.getClient());
        }
        if(vo.getClientVersion()!=null){
            entity.setClientVersion(vo.getClientVersion());
        }
        if(vo.getClientVersionNumber()!=null){
            entity.setClientVersionNumber(vo.getClientVersionNumber());
        }
        if(vo.getLastLogoutType()!=null){
            entity.setLastLogoutType(vo.getLastLogoutType());
        }
        if(vo.getLastLoginTime()!=null){
            entity.setLastLoginTime(vo.getLastLoginTime());
        }
        if(vo.getLastLogoutTime()!=null){
            entity.setLastLogoutTime(vo.getLastLogoutTime());
        }
        if(vo.getLastLoginIp()!=null){
            entity.setLastLoginIp(vo.getLastLoginIp());
        }
        if(vo.getLastLoginSource()!=null){
            entity.setLastLoginSource(vo.getLastLoginSource());
        }
        if(vo.getLastLoginType()!=null){
            entity.setLastLoginType(vo.getLastLoginType());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }


    public static AccountRoleVo convert(AccountRole entity) {
        AccountRoleVo vo= new AccountRoleVo();
        return convert(entity,vo);
    }

    public static AccountRoleVo convert(AccountRole entity,AccountRoleVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Account account = entity.getAccount();
        if(account!=null){
            vo.setAccountId(account.getId());
        }
        Role role = entity.getRole();
        if(role!=null){
            vo.setRoleId(role.getId());
        }
        vo.setExpiry(entity.getExpiry());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static AccountRole convert(AccountRoleVo vo) {
        AccountRole entity= new AccountRole();
        return convert(vo,entity);
    }

    public static AccountRole convert(AccountRoleVo vo,AccountRole entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Account account = entity.getAccount();
        if(account!=null){
            account.setId(vo.getAccountId());
        }
        Role role = entity.getRole();
        if(role!=null){
            role.setId(vo.getRoleId());
        }
        entity.setExpiry(vo.getExpiry());
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static AccountValueVo convert(AccountValue entity) {
        AccountValueVo vo= new AccountValueVo();
        return convert(entity,vo);
    }

    public static AccountValueVo convert(AccountValue entity,AccountValueVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Account account = entity.getAccount();
        if(account!=null){
            vo.setAccountId(account.getId());
        }
        vo.setKey(entity.getKey());
        vo.setValue(entity.getValue());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static AccountValue convert(AccountValueVo vo) {
        AccountValue entity= new AccountValue();
        return convert(vo,entity);
    }

    public static AccountValue convert(AccountValueVo vo,AccountValue entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Account account = entity.getAccount();
        if(account!=null){
            account.setId(vo.getAccountId());
        }
        if(vo.getKey()!=null){
            entity.setKey(vo.getKey());
        }
        if(vo.getValue()!=null){
            entity.setValue(vo.getValue());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static ContainerVo convert(Container entity) {
        ContainerVo vo= new ContainerVo();
        return convert(entity,vo);
    }

    public static ContainerVo convert(Container entity,ContainerVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Container parent = entity.getParent();
        if(parent!=null){
            vo.setParentId(parent.getId());
        }
        vo.setName(entity.getName());
        vo.setDescription(entity.getDescription());
        vo.setLevel(entity.getLevel());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static Container convert(ContainerVo vo) {
        Container entity= new Container();
        return convert(vo,entity);
    }

    public static Container convert(ContainerVo vo,Container entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Container parent = entity.getParent();
        if(parent!=null){
            parent.setId(vo.getParentId());
        }
        if(vo.getName()!=null){
            entity.setName(vo.getName());
        }
        if(vo.getDescription()!=null){
            entity.setDescription(vo.getDescription());
        }
        if(vo.getLevel()!=null){
            entity.setLevel(vo.getLevel());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static ContainerPermissionVo convert(ContainerPermission entity) {
        ContainerPermissionVo vo= new ContainerPermissionVo();
        return convert(entity,vo);
    }

    public static ContainerPermissionVo convert(ContainerPermission entity,ContainerPermissionVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Container container = entity.getContainer();
        if(container!=null){
            vo.setContainerId(container.getId());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            vo.setPermissionId(permission.getId());
        }
        vo.setExpire(entity.getExpire());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static ContainerPermission convert(ContainerPermissionVo vo) {
        ContainerPermission entity= new ContainerPermission();
        return convert(vo,entity);
    }

    public static ContainerPermission convert(ContainerPermissionVo vo,ContainerPermission entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Container container = entity.getContainer();
        if(container!=null){
            container.setId(vo.getContainerId());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            permission.setId(vo.getPermissionId());
        }
        if(vo.getExpire()!=null){
            entity.setExpire(vo.getExpire());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static DirectPermissionVo convert(DirectPermission entity) {
        DirectPermissionVo vo= new DirectPermissionVo();
        return convert(entity,vo);
    }

    public static DirectPermissionVo convert(DirectPermission entity,DirectPermissionVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Account account = entity.getAccount();
        if(account!=null){
            vo.setAccountId(account.getId());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            vo.setPermissionId(permission.getId());
        }
        vo.setExpiry(entity.getExpiry());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static DirectPermission convert(DirectPermissionVo vo) {
        DirectPermission entity= new DirectPermission();
        return convert(vo,entity);
    }

    public static DirectPermission convert(DirectPermissionVo vo,DirectPermission entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Account account = entity.getAccount();
        if(account!=null){
            account.setId(vo.getAccountId());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            permission.setId(vo.getPermissionId());
        }
        if(vo.getExpiry()!=null){
            entity.setExpiry(vo.getExpiry());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static HelloWorldVo convert(HelloWorld entity) {
        HelloWorldVo vo= new HelloWorldVo();
        return convert(entity,vo);
    }

    public static HelloWorldVo convert(HelloWorld entity,HelloWorldVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        vo.setStr(entity.getStr());
        vo.setNumber(entity.getNumber());
        vo.setVersion(entity.getVersion());
        return vo;
    }






    public static LoginRecordVo convert(LoginRecord entity) {
        LoginRecordVo vo= new LoginRecordVo();
        return convert(entity,vo);
    }

    public static LoginRecordVo convert(LoginRecord entity,LoginRecordVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Account account = entity.getAccount();
        if(account!=null){
            vo.setAccountId(account.getId());
        }
        vo.setLoginTime(entity.getLoginTime());
        vo.setLoginDate(entity.getLoginDate());
        vo.setLogoutTime(entity.getLogoutTime());
        vo.setLogoutDate(entity.getLogoutDate());
        vo.setLoginType(entity.getLoginType());
        vo.setLoginTypeStr(entity.getLoginTypeStr());
        vo.setLogoutType(entity.getLogoutType());
        vo.setLogoutTypeStr(entity.getLogoutTypeStr());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static LoginRecord convert(LoginRecordVo vo) {
        LoginRecord entity= new LoginRecord();
        return convert(vo,entity);
    }

    public static LoginRecord convert(LoginRecordVo vo,LoginRecord entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Account account = entity.getAccount();
        if(account!=null){
            account.setId(vo.getAccountId());
        }
        entity.setLoginTime(vo.getLoginTime());
        if(vo.getLoginDate()!=null){
            entity.setLoginDate(vo.getLoginDate());
        }
        entity.setLogoutTime(vo.getLogoutTime());
        if(vo.getLogoutDate()!=null){
            entity.setLogoutDate(vo.getLogoutDate());
        }
        entity.setLoginType(vo.getLoginType());
        if(vo.getLoginTypeStr()!=null){
            entity.setLoginTypeStr(vo.getLoginTypeStr());
        }
        entity.setLogoutType(vo.getLogoutType());
        if(vo.getLogoutTypeStr()!=null){
            entity.setLogoutTypeStr(vo.getLogoutTypeStr());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static PermissionVo convert(Permission entity) {
        PermissionVo vo= new PermissionVo();
        return convert(entity,vo);
    }

    public static PermissionVo convert(Permission entity,PermissionVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        vo.setName(entity.getName());
        vo.setType(entity.getType());
        vo.setResourceVerifyName(entity.getResourceVerifyName());
        vo.setDescription(entity.getDescription());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static Permission convert(PermissionVo vo) {
        Permission entity= new Permission();
        return convert(vo,entity);
    }

    public static Permission convert(PermissionVo vo,Permission entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        if(vo.getName()!=null){
            entity.setName(vo.getName());
        }
        if(vo.getType()!=null){
            entity.setType(vo.getType());
        }
        if(vo.getResourceVerifyName()!=null){
            entity.setResourceVerifyName(vo.getResourceVerifyName());
        }
        if(vo.getDescription()!=null){
            entity.setDescription(vo.getDescription());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static RoleVo convert(Role entity) {
        RoleVo vo= new RoleVo();
        return convert(entity,vo);
    }

    public static RoleVo convert(Role entity,RoleVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Container container = entity.getContainer();
        if(container!=null){
            vo.setContainerId(container.getId());
        }
        vo.setName(entity.getName());
        vo.setAdmin(entity.getAdmin());
        vo.setDescription(entity.getDescription());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static Role convert(RoleVo vo) {
        Role entity= new Role();
        return convert(vo,entity);
    }

    public static Role convert(RoleVo vo,Role entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Container container = entity.getContainer();
        if(container!=null){
            container.setId(vo.getContainerId());
        }
        if(vo.getName()!=null){
            entity.setName(vo.getName());
        }
       // if(vo.getAdmin()!=null){
           // entity.setAdmin(vo.getAdmin());
       // }
        if(vo.getDescription()!=null){
            entity.setDescription(vo.getDescription());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static RolePermissionVo convert(RolePermission entity) {
        RolePermissionVo vo= new RolePermissionVo();
        return convert(entity,vo);
    }

    public static RolePermissionVo convert(RolePermission entity,RolePermissionVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Permission permission = entity.getPermission();
        if(permission!=null){
            vo.setPermissionId(permission.getId());
        }
        Role role = entity.getRole();
        if(role!=null){
            vo.setRoleId(role.getId());
        }
        vo.setExpiry(entity.getExpiry());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static RolePermission convert(RolePermissionVo vo) {
        RolePermission entity= new RolePermission();
        return convert(vo,entity);
    }

    public static RolePermission convert(RolePermissionVo vo,RolePermission entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            permission.setId(vo.getPermissionId());
        }
        Role role = entity.getRole();
        if(role!=null){
            role.setId(vo.getRoleId());
        }
        if(vo.getExpiry()!=null){
            entity.setExpiry(vo.getExpiry());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static RoleValueVo convert(RoleValue entity) {
        RoleValueVo vo= new RoleValueVo();
        return convert(entity,vo);
    }

    public static RoleValueVo convert(RoleValue entity,RoleValueVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        Role role = entity.getRole();
        if(role!=null){
            vo.setRoleId(role.getId());
        }
        vo.setKey(entity.getKey());
        vo.setValue(entity.getValue());
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static RoleValue convert(RoleValueVo vo) {
        RoleValue entity= new RoleValue();
        return convert(vo,entity);
    }

    public static RoleValue convert(RoleValueVo vo,RoleValue entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        Role role = entity.getRole();
        if(role!=null){
            role.setId(vo.getRoleId());
        }
        if(vo.getKey()!=null){
            entity.setKey(vo.getKey());
        }
        if(vo.getValue()!=null){
            entity.setValue(vo.getValue());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }

    public static URIPermissionVo convert(URIPermission entity) {
        URIPermissionVo vo= new URIPermissionVo();
        return convert(entity,vo);
    }

    public static URIPermissionVo convert(URIPermission entity,URIPermissionVo vo) {
        vo.setId(entity.getId());
        vo.setVersion(entity.getVersion());
        vo.setUriAndMethod(entity.getUriAndMethod());
        Permission permission = entity.getPermission();
        if(permission!=null){
            vo.setPermissionId(permission.getId());
        }
        vo.setVersion(entity.getVersion());
        return vo;
    }

    public static URIPermission convert(URIPermissionVo vo) {
        URIPermission entity= new URIPermission();
        return convert(vo,entity);
    }

    public static URIPermission convert(URIPermissionVo vo,URIPermission entity) {
        if(vo.getId()!=null){
            entity.setId(vo.getId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        if(vo.getUriAndMethod()!=null){
            entity.setUriAndMethod(vo.getUriAndMethod());
        }
        Permission permission = entity.getPermission();
        if(permission!=null){
            permission.setId(vo.getPermissionId());
        }
        if(vo.getVersion()!=null){
            entity.setVersion(vo.getVersion());
        }
        return entity;
    }








}
