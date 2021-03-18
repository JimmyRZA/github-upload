package com.banking.system.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	private int clientId;
	private String title;
	private String name;
	private String surname;
	private String dob;
	private String clientSubTypeCode;
	
	public Client() {
		
	}
	
	public Client(int clientId, String title, String name, String surname, String dob, String clientSubTypeCode) {
		super();
		this.clientId = clientId;
		this.title = title;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.clientSubTypeCode = clientSubTypeCode;
	}
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getClientSubTypeCode() {
		return clientSubTypeCode;
	}
	public void setClientSubTypeCode(String clientSubTypeCode) {
		this.clientSubTypeCode = clientSubTypeCode;
	}
	
	

}
