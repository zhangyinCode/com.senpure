package com.senpure.base.entity;


import com.senpure.AppConstant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Table(name = AppConstant.DB_BASE_PREFIX + "_CONTAINER")
public class Container extends IntEntity {

	private static final long serialVersionUID = -6627339494431946014L;
	/**
	 * 父容器，实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parentId", nullable = true)
	private Container parent;
	/**
	 * 子容器，实体
	 */
	@OneToMany(mappedBy = "parent")
	private List<Container> children;
	@OneToMany(mappedBy = "container")
	private List<Account> accounts;
	@OneToMany(mappedBy = "container", cascade = CascadeType.REMOVE)
	private List<ContainerPermission> containerPermissions;
	@OneToMany(mappedBy = "container", cascade = CascadeType.REMOVE)
	private List<Role> roles;

	@Column(nullable = false, length = 32)
	private String name;
	private String description;
	private Integer level ;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}

	public List<Container> getChildren() {
		return children;
	}

	public void setChildren(List<Container> children) {
		this.children = children;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<ContainerPermission> getContainerPermissions() {
		return containerPermissions;
	}

	public void setContainerPermissions(
			List<ContainerPermission> containerPermissions) {
		this.containerPermissions = containerPermissions;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
