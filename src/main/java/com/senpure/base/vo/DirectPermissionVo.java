package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class DirectPermissionVo implements Serializable {
	private static final long serialVersionUID = 1486464399989L;


	private	Integer id;
	private	Integer accountId;
	private	Integer permissionId;
	private	Long expiry;
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

	public Integer getPermissionId() {
		return permissionId;
	}


	public	void setPermissionId(Integer permissionId) {
		this.permissionId=permissionId ;
	}

	public Long getExpiry() {
		return expiry;
	}


	public	void setExpiry(Long expiry) {
		this.expiry=expiry ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}