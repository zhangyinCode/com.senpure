package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class AccountValueVo implements Serializable {
	private static final long serialVersionUID = 1486464399954L;


	private	Integer id;
	private	Integer accountId;
	private	String key;
	private	String value;
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

	public String getKey() {
		return key;
	}


	public	void setKey(String key) {
		this.key=key ;
	}

	public String getValue() {
		return value;
	}


	public	void setValue(String value) {
		this.value=value ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}