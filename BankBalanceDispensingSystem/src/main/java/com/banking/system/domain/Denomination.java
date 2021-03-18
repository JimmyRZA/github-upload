package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Denomination {
	@Id
	private int denominationId;
	private double value;
	private char denominationTypeCode;
	
	public Denomination() {
		
	}
	
	public Denomination(int denominationId, int value, char denominationTypeCode) {
		super();
		this.denominationId = denominationId;
		this.value = value;
		this.denominationTypeCode = denominationTypeCode;
	}
	
	
	public int getDenominationId() {
		return denominationId;
	}
	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public char getDenominationTypeCode() {
		return denominationTypeCode;
	}
	public void setDenominationTypeCode(char denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}
	
	

}
