package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Denomination_Type {
	@Id
	private char denominationTypeCode;
	private String description;
	
	public Denomination_Type() {
		
	}
	
	public Denomination_Type(char denominationTypeCode, String description) {
		super();
		this.denominationTypeCode = denominationTypeCode;
		this.description = description;
	}
	
	public char getDenominationTypeCode() {
		return denominationTypeCode;
	}
	public void setDenominationTypeCode(char denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
