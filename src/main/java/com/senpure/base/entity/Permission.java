package com.senpure.base.entity;


import com.senpure.AppConstant;


import javax.persistence.Column;
import javax.persistence.Table;


@Table(name = AppConstant.DB_BASE_PREFIX + "_RMISSION")
public class Permission extends IntEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7137920267258203370L;
	@Column(nullable = false, length = 128)
	private String name;


	/**
	 *NORMAL 正常 ，OWNER 检查所有者，IGNORE 可以忽略(正常放行)
	 */
	@Column(nullable = false, length = 12)
	private String type;
	/**
	 * 由那个类来验证资源所有者
	 */

	private String ownerClass;
	private String       description;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerClass() {
		return ownerClass;
	}

	public void setOwnerClass(String ownerClass) {
		this.ownerClass = ownerClass;
	}
}
