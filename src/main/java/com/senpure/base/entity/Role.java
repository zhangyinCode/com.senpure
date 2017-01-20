package com.senpure.base.entity;


import com.senpure.AppConstant;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Table(name = AppConstant.DB_BASE_PREFIX + "_ROLE")
public class Role extends IntEntity {
	private static final long serialVersionUID = -7767418310648447445L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "containerId")
	private Container container;

	@OneToMany(mappedBy = "role")
	private List<RolePermission> rolePermissions;

	@Column(nullable = false, length = 32)
	private String name;
	// 容器管理员
	private Boolean admin;
	private String description;

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

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public List<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	
}
