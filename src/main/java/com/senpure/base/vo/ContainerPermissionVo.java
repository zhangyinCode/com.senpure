package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class ContainerPermissionVo implements Serializable {
	private static final long serialVersionUID = 1486464399975L;


	private	Integer id;
	private	Integer containerId;
	private	Integer permissionId;
	private	Long expire;
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

	public Integer getPermissionId() {
		return permissionId;
	}


	public	void setPermissionId(Integer permissionId) {
		this.permissionId=permissionId ;
	}

	public Long getExpire() {
		return expire;
	}


	public	void setExpire(Long expire) {
		this.expire=expire ;
	}

	public Integer getVersion() {
		return version;
	}


	public	void setVersion(Integer version) {
		this.version=version ;
	}

}