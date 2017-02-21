package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class PermissionVo implements Serializable {
	private static final long serialVersionUID = 1486464400017L;


	private	Integer id;
	private	String name;
	private	String type;
	private	String resourceVerifyName;
	private	String description;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public String getName() {
		return name;
	}


	public	void setName(String name) {
		this.name=name ;
	}

	public String getType() {
		return type;
	}


	public	void setType(String type) {
		this.type=type ;
	}

	public String getResourceVerifyName() {
		return resourceVerifyName;
	}


	public	void setResourceVerifyName(String resourceVerifyName) {
		this.resourceVerifyName=resourceVerifyName ;
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