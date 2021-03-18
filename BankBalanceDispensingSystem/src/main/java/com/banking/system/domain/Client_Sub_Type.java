package com.banking.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client_Sub_Type {
	@Id
	private String clientSubTypeCode;
	private String clientTypeCode;
	private String description;
	
	public Client_Sub_Type() {
		
	}
	
	public Client_Sub_Type(String clientSubTypeCode, String clientTypeCode, String description) {
		super();
		this.clientSubTypeCode = clientSubTypeCode;
		this.clientTypeCode = clientTypeCode;
		this.description = description;
	}
	public String getClientSubTypeCode() {
		return clientSubTypeCode;
	}
	public void setClientSubTypeCode(String clientSubTypeCode) {
		this.clientSubTypeCode = clientSubTypeCode;
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
