package com.senpure.base.entity;

import com.senpure.AppConstant;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name = AppConstant.DB_BASE_PREFIX+"_ACCOUNT_ROLE")
public class AccountRole extends IntEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1594909852545869189L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountId")
	private Account account;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;
	private long expiry;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getExpiry() {
		return expiry;
	}
	public void setExpiry(long expiry) {
		this.expiry = expiry;
	}
	
}
