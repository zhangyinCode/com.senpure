package com.senpure.base.entity;


import com.senpure.AppConstant;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = AppConstant.DB_BASE_PREFIX + "_ROLE_VALUE")
public class RoleValue extends IntEntity {
	private static final long serialVersionUID = 4387681837130997965L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
