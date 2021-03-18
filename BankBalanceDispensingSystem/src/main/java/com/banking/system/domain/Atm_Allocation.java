package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atm_Allocation {
	@Id
	private int atmAllocationId;
	private int atmId;
	private int denominationId;
	private int count;
	
	public Atm_Allocation() {
		
	}
	
	public Atm_Allocation(int atmAllocationId, int atmId, int denominationId, int count) {
		super();
		this.atmAllocationId = atmAllocationId;
		this.atmId = atmId;
		this.denominationId = denominationId;
		this.count = count;
	}
	
	public int getAtmAllocationId() {
		return atmAllocationId;
	}
	public void setAtmAllocationId(int atmAllocationId) {
		this.atmAllocationId = atmAllocationId;
	}
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public int getDenominationId() {
		return denominationId;
	}
	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	

}
