package com.restful.Requests;

import org.springframework.stereotype.Component;

@Component
public class FindByemailMethodRequest {
	public String email;
	
	public FindByemailMethodRequest() {}
	
	public FindByemailMethodRequest(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
