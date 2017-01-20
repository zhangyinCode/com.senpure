package com.senpure.base.entity;


import com.senpure.AppConstant;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = AppConstant.DB_BASE_PREFIX + "_ROLE_PERMISSION")
public class RolePermission extends IntEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2404844436780625172L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="permisssionId")
	private Permission permission;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;

private Long expiry;

public Permission getPermission() {
	return permission;
}
public void setPermission(Permission permission) {
	this.permission = permission;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Long getExpiry() {
	return expiry;
}
public void setExpiry(Long expiry) {
	this.expiry = expiry;
}




}
