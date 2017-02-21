package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class RoleVo implements Serializable {
	private static final long serialVersionUID = 1486464400025L;


	private	Integer id;
	private	Integer containerId;
	private	String name;
	private	Boolean admin;
	private	String description;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public Integer getContainerId() {
		return containerId;
	}


	public	void setContainerId(Integer containerId) {
		this.containerId=containerId ;
	}

	public String getName() {
		return name;
	}


	public	void setName(String name) {
		this.name=name ;
	}

	public Boolean isAdmin() {
		return admin;
	}


	public	void setAdmin(Boolean admin) {
		this.admin=admin ;
	}

	public String getDescription() {
		return description;
	}


	public	void setDescription(String description) {
		this.description=description ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}