package com.restful.Requests;

import org.springframework.stereotype.Component;

@Component
public class FindBynameMethodRequest {

	private String name;
	
	public FindBynameMethodRequest() {}
	
	public FindBynameMethodRequest(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
