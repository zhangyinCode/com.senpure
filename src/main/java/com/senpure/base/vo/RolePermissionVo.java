package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class RolePermissionVo implements Serializable {
	private static final long serialVersionUID = 1486464400030L;


	private	Integer id;
	private	Integer permissionId;
	private	Integer roleId;
	private	Long expiry;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public Integer getPermissionId() {
		return permissionId;
	}


	public	void setPermissionId(Integer permissionId) {
		this.permissionId=permissionId ;
	}

	public Integer getRoleId() {
		return roleId;
	}


	public	void setRoleId(Integer roleId) {
		this.roleId=roleId ;
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