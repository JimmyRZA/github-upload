package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account_Type {
	@Id
	private String AccountTypeCode;
	
	
	private String description;
	private int transactional;
	
	public Account_Type() {
		
	}
	
	public Account_Type(String accountTypeCode, String description, int transactional) {
		super();
		AccountTypeCode = accountTypeCode;
		this.description = description;
		this.transactional = transactional;
	}
	
	public String getAccountTypeCode() {
		return AccountTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		AccountTypeCode = accountTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTransactional() {
		return transactional;
	}
	public void setTransactional(short transactional) {
		this.transactional = transactional;
	}
	
	

}
