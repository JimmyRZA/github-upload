package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credit_Card_Limit {
	@Id
	private String clientAccountNumber;
	private double accountLimit;
	
	public Credit_Card_Limit() {
		
	}
	
	public Credit_Card_Limit(String clientAccountNumber, double accountLimit) {
		super();
		this.clientAccountNumber = clientAccountNumber;
		this.accountLimit = accountLimit;
	}
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public double getAccountLimit() {
		return accountLimit;
	}
	public void setAccountLimit(double accountLimit) {
		this.accountLimit = accountLimit;
	}
	
	

}
