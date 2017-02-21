package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class LoginRecordVo implements Serializable {
	private static final long serialVersionUID = 1486464400010L;


	private	Integer id;
	private	Integer accountId;
	private	long loginTime;
	private	Date loginDate;
	private	long logoutTime;
	private	Date logoutDate;
	private	int loginType;
	private	String loginTypeStr;
	private	int logoutType;
	private	String logoutTypeStr;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public Integer getAccountId() {
		return accountId;
	}


	public	void setAccountId(Integer accountId) {
		this.accountId=accountId ;
	}

	public long getLoginTime() {
		return loginTime;
	}


	public	void setLoginTime(long loginTime) {
		this.loginTime=loginTime ;
	}

	public Date getLoginDate() {
		return loginDate;
	}


	public	void setLoginDate(Date loginDate) {
		this.loginDate=loginDate ;
	}

	public long getLogoutTime() {
		return logoutTime;
	}


	public	void setLogoutTime(long logoutTime) {
		this.logoutTime=logoutTime ;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}


	public	void setLogoutDate(Date logoutDate) {
		this.logoutDate=logoutDate ;
	}

	public int getLoginType() {
		return loginType;
	}


	public	void setLoginType(int loginType) {
		this.loginType=loginType ;
	}

	public String getLoginTypeStr() {
		return loginTypeStr;
	}


	public	void setLoginTypeStr(String loginTypeStr) {
		this.loginTypeStr=loginTypeStr ;
	}

	public int getLogoutType() {
		return logoutType;
	}


	public	void setLogoutType(int logoutType) {
		this.logoutType=logoutType ;
	}

	public String getLogoutTypeStr() {
		return logoutTypeStr;
	}


	public	void setLogoutTypeStr(String logoutTypeStr) {
		this.logoutTypeStr=logoutTypeStr ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}