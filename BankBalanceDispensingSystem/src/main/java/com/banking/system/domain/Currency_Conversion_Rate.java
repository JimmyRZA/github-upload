package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency_Conversion_Rate {
	@Id
	private String currencyCode;
	private char conversionIndicator;
	private float rate;
	
	public Currency_Conversion_Rate() {
		
	}
	
	public Currency_Conversion_Rate(String currencyCode, char conversionIndicator, float rate) {
		super();
		this.currencyCode = currencyCode;
		this.conversionIndicator = conversionIndicator;
		this.rate = rate;
	}
	
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public char getConversionIndicator() {
		return conversionIndicator;
	}
	public void setConversionIndicator(char conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	

}
