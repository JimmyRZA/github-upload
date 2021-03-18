package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client_Type {
	@Id
	private String clientTypeCode;
	private String description;
	
	public Client_Type() {
		
	}
	
	public Client_Type(String clientTypeCode, String description) {
		super();
		this.clientTypeCode = clientTypeCode;
		this.description = description;
	}
	public String getClientTypeCode() {
		return clientTypeCode;
	}
	public void setClientTypeCode(String clientTypeCode) {
		this.clientTypeCode = clientTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
