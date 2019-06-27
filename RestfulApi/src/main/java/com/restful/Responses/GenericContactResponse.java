package com.restful.Responses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restful.Entities.Contact;

@Component
public class GenericContactResponse {
	
	@Autowired
	private Contact contact;
	private String status;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public GenericContactResponse() {}

	public GenericContactResponse(Contact contact, String status) {
		super();
		this.contact = contact;
		this.status = status;
	}

	
	

}
