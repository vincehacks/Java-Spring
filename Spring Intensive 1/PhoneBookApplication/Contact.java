package com.di.phonebook.domain;

public class Contact {
	private String name;
	private String phone;
	private String id;
	public Contact(String id, String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String toString(){
		return this.getName() + " \t"+this.getPhone();
	}	
}