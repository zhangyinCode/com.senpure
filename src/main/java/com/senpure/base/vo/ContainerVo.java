package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class ContainerVo implements Serializable {
	private static final long serialVersionUID = 1486464399966L;


	private	Integer id;
	private	Integer parentId;
	private	String name;
	private	String description;
	private	Integer level;
	private	Integer version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public Integer getParentId() {
		return parentId;
	}


	public	void setParentId(Integer parentId) {
		this.parentId=parentId ;
	}

	public String getName() {
		return name;
	}


	public	void setName(String name) {
		this.name=name ;
	}

	public String getDescription() {
		return description;
	}


	public	void setDescription(String description) {
		this.description=description ;
	}

	public Integer getLevel() {
		return level;
	}


	public	void setLevel(Integer level) {
		this.level=level ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}