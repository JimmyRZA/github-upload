package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client_Account {
	@Id
	private String clientAccountNumber;
	private int clientId;
	
	private String accountTypeCode;
	
	private String currencyCode;
	private float displayBalance;

	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	
	
	public Client_Account() {
		
	}
				
	public Client_Account(String clientAccountNumber, int clientId, String accountTypeCode, String currencyCode,
			float displayBalance) {
		super();
		this.clientAccountNumber = clientAccountNumber;
		this.clientId = clientId;
		this.accountTypeCode = accountTypeCode;
		this.currencyCode = currencyCode;
		this.displayBalance = displayBalance;
	}




	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getAccountTypeCode() {
		return accountTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public float getDisplayBalance() {
		return displayBalance;
	}
	public void setDisplayBalance(float displayBalance) {
		this.displayBalance = displayBalance;
	}
	
	

}
