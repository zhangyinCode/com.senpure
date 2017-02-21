package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class RoleValueVo implements Serializable {
	private static final long serialVersionUID = 1486464400038L;


	private	Integer id;
	private	Integer roleId;
	private	String key;
	private	String value;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public Integer getRoleId() {
		return roleId;
	}


	public	void setRoleId(Integer roleId) {
		this.roleId=roleId ;
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