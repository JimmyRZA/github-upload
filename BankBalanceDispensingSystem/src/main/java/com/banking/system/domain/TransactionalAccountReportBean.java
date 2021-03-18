package com.banking.system.domain;

import org.springframework.stereotype.Component;

@Component
public class TransactionalAccountReportBean {
	
	private String clientId;
	private String clientSurname;
	private String clientAccountNumber;
	private String accountDescription;
	private String displayBalance;
	
	
	public TransactionalAccountReportBean() {
		
	}
			
	public TransactionalAccountReportBean(String clientId, String clientSurname, String clientAccountNumber,
			String accountDescription, String displayBalance) {
		super();
		this.clientId = clientId;
		this.clientSurname = clientSurname;
		this.clientAccountNumber = clientAccountNumber;
		this.accountDescription = accountDescription;
		this.displayBalance = displayBalance;
	}
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSurname() {
		return clientSurname;
	}
	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	public String getDisplayBalance() {
		return displayBalance;
	}
	public void setDisplayBalance(String displayBalance) {
		this.displayBalance = displayBalance;
	}
	
	


}
