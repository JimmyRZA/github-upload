package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	private String currencyCode;
	private int decimalPlaces;
	private String description;
	
	public Currency() {
		
	}
	
	public Currency(String currencyCode, int decimalPlaces, String description) {
		super();
		this.currencyCode = currencyCode;
		this.decimalPlaces = decimalPlaces;
		this.description = description;
	}
	
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public int getDecimalPlaces() {
		return decimalPlaces;
	}
	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
