package com.banking.system.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class AmountDetails {
	private String accountNumber;
	private String type;
	private int amount;
	
	public AmountDetails() {
		
	}
	
	public  AmountDetails(String accountNumber, String type, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
	}
	
	public synchronized String getAccountNumber() {
		return accountNumber;
	}
	public synchronized void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public synchronized String getType() {
		return type;
	}
	public synchronized void setType(String type) {
		this.type = type;
	}
	public synchronized int getAmount() {
		return amount;
	}
	public synchronized void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
