package com.senpure.base.entity;


import com.senpure.AppConstant;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = AppConstant.DB_BASE_PREFIX + "_DIRECTPE_RMISSION")
public class DirectPermission extends IntEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531016660138769839L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "permissionId")
	private Permission permission;
	
	private Long expiry;



	public Long getExpiry() {
		return expiry;
	}

	public void setExpiry(Long expiry) {
		this.expiry = expiry;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	

}
