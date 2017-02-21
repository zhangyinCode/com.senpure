package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class AccountVo implements Serializable {
	private static final long serialVersionUID = 1486472944370L;


	private	Integer id;
	private	String account;
	private	String password;
	private	long createTime;
	private	Date createDate;
	private	String name;
	private	String ip;
	private	Long ipNumber;
	private	String source;
	private	Long ban;
	private	Long banExpiry;
	private	Long loginTime;
	private	Boolean online;
	private	String accountState;
	private	String loginType;
	private	String client;
	private	String clientVersion;
	private	Integer clientVersionNumber;
	private	String lastLogoutType;
	private	Long lastLoginTime;
	private	Long lastLogoutTime;
	private	String lastLoginIp;
	private	String lastLoginSource;
	private	String lastLoginType;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public String getAccount() {
		return account;
	}


	public	void setAccount(String account) {
		this.account=account ;
	}

	public String getPassword() {
		return password;
	}


	public	void setPassword(String password) {
		this.password=password ;
	}

	public long getCreateTime() {
		return createTime;
	}


	public	void setCreateTime(long createTime) {
		this.createTime=createTime ;
	}

	public Date getCreateDate() {
		return createDate;
	}


	public	void setCreateDate(Date createDate) {
		this.createDate=createDate ;
	}

	public String getName() {
		return name;
	}


	public	void setName(String name) {
		this.name=name ;
	}

	public String getIp() {
		return ip;
	}


	public	void setIp(String ip) {
		this.ip=ip ;
	}

	public Long getIpNumber() {
		return ipNumber;
	}


	public	void setIpNumber(Long ipNumber) {
		this.ipNumber=ipNumber ;
	}

	public String getSource() {
		return source;
	}


	public	void setSource(String source) {
		this.source=source ;
	}

	public Long getBan() {
		return ban;
	}


	public	void setBan(Long ban) {
		this.ban=ban ;
	}

	public Long getBanExpiry() {
		return banExpiry;
	}


	public	void setBanExpiry(Long banExpiry) {
		this.banExpiry=banExpiry ;
	}

	public Long getLoginTime() {
		return loginTime;
	}


	public	void setLoginTime(Long loginTime) {
		this.loginTime=loginTime ;
	}

	public Boolean isOnline() {
		return online;
	}


	public	void setOnline(Boolean online) {
		this.online=online ;
	}

	public String getAccountState() {
		return accountState;
	}


	public	void setAccountState(String accountState) {
		this.accountState=accountState ;
	}

	public String getLoginType() {
		return loginType;
	}


	public	void setLoginType(String loginType) {
		this.loginType=loginType ;
	}

	public String getClient() {
		return client;
	}


	public	void setClient(String client) {
		this.client=client ;
	}

	public String getClientVersion() {
		return clientVersion;
	}


	public	void setClientVersion(String clientVersion) {
		this.clientVersion=clientVersion ;
	}

	public Integer getClientVersionNumber() {
		return clientVersionNumber;
	}


	public	void setClientVersionNumber(Integer clientVersionNumber) {
		this.clientVersionNumber=clientVersionNumber ;
	}

	public String getLastLogoutType() {
		return lastLogoutType;
	}


	public	void setLastLogoutType(String lastLogoutType) {
		this.lastLogoutType=lastLogoutType ;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}


	public	void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime=lastLoginTime ;
	}

	public Long getLastLogoutTime() {
		return lastLogoutTime;
	}


	public	void setLastLogoutTime(Long lastLogoutTime) {
		this.lastLogoutTime=lastLogoutTime ;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}


	public	void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp=lastLoginIp ;
	}

	public String getLastLoginSource() {
		return lastLoginSource;
	}


	public	void setLastLoginSource(String lastLoginSource) {
		this.lastLoginSource=lastLoginSource ;
	}

	public String getLastLoginType() {
		return lastLoginType;
	}


	public	void setLastLoginType(String lastLoginType) {
		this.lastLoginType=lastLoginType ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}