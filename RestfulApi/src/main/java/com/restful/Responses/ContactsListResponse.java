package com.restful.Responses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restful.Entities.Contact;


public class ContactsListResponse {
	

	@Autowired
	private List<Contact> contactList;
	private String status;
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ContactsListResponse(List<Contact> contactList, String status) {
		super();
		this.contactList = contactList;
		this.status = status;
	}
	
	public ContactsListResponse() {}
	
	
	

}
