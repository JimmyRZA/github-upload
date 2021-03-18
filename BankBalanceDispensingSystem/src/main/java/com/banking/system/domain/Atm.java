package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atm {
	@Id
	private int atmId;
	private String name;
	private String location;
	
	public Atm() {
		
	}
	
	public Atm(int atmId, String name, String location) {
		super();
		this.atmId = atmId;
		this.name = name;
		this.location = location;
	}
	
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
