package com.restful.Requests;

public class FindByStateMethodRequest {
	private String state;
	
	FindByStateMethodRequest(){}
	public FindByStateMethodRequest(String stat) {
		super();
		this.state = stat;
	}

	public String getState() {
		return state;
	}

	public void setState(String stat) {
		this.state = stat;
	}

	
	

}
