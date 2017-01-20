package com.senpure.base.entity;


import com.senpure.AppConstant;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = AppConstant.DB_BASE_PREFIX + "_CONTAINER_PERMISSION")
public class ContainerPermission extends IntEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5080867717001924566L;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="containerId")
	private Container container;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="permissionId")
	private Permission permission;
	

	private Long expire;
	
	public Long getExpire() {
		return expire;
	}
	public void setExpire(Long expire) {
		this.expire = expire;
	}
	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
	

}
