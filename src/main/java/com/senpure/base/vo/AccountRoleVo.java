package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class AccountRoleVo implements Serializable {
	private static final long serialVersionUID = 1486464399948L;


	private	Integer id;
	private	Integer accountId;
	private	Integer roleId;
	private	long expiry;
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

	public Integer getRoleId() {
		return roleId;
	}


	public	void setRoleId(Integer roleId) {
		this.roleId=roleId ;
	}

	public long getExpiry() {
		return expiry;
	}


	public	void setExpiry(long expiry) {
		this.expiry=expiry ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}