package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class URIPermissionVo implements Serializable {
	private static final long serialVersionUID = 1486464400041L;


	private	Integer id;
	private	String uriAndMethod;
	private	Integer permissionId;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public String getUriAndMethod() {
		return uriAndMethod;
	}


	public	void setUriAndMethod(String uriAndMethod) {
		this.uriAndMethod=uriAndMethod ;
	}

	public Integer getPermissionId() {
		return permissionId;
	}


	public	void setPermissionId(Integer permissionId) {
		this.permissionId=permissionId ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}