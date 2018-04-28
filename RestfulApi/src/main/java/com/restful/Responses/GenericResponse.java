package com.restful.Responses;

import org.springframework.stereotype.Component;

/*This class is used for response when a create method on the Rest Api is called 
 */
@Component
public class GenericResponse {
	
	private String status;
	private String comments;
	private String date;
	
	public GenericResponse() {};
	
	public GenericResponse(String status, String comments, String date) {
		super();
		this.status = status;
		this.comments = comments;
		this.date = date;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
