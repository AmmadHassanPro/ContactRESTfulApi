package com.restful.RestfulApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.DAO.ContactDAO;
import com.restful.Entities.Contact;
import com.restful.Requests.FindByStateMethodRequest;
import com.restful.Requests.FindByemailMethodRequest;
import com.restful.Requests.FindBynameMethodRequest;
import com.restful.Responses.ContactsListResponse;
import com.restful.Responses.GenericResponse;
import com.restful.Responses.GenericContactResponse;

/**
 * @author ammadhassan
 * This class represents the Rest Layer or the Controller of the ContactREST api
 */

@Controller
public class ContactREST {
	private Contact contactRec;
	@Autowired
	private ContactDAO conDAO;
	
	private GenericResponse createMethodResponse;
	
	public ContactREST(ContactDAO daoLayer) {
		
		this.conDAO = daoLayer;
	}
	
	@RequestMapping(value = "/Create" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody GenericResponse insertContact(@RequestBody Contact contact) {
		//Saving reference
		contactRec = contact;
		
		//Saving Object in persistence Layer
		String res = conDAO.Save(contact);
	
		//Checking for any error
		if(res.contains("error")) {
			// Creating response based on the condition
			createMethodResponse = new GenericResponse("400" , "Bad Request or Backend Error", LocalDateTime.now().toString());
			//Response
			return  createMethodResponse;		
		}
		
		else {
		// Creating response based on the condition	
		createMethodResponse = new GenericResponse("200" , "Contact Added Successfully", LocalDateTime.now().toString());
		//Response
		return  createMethodResponse;
		}		
	}
	
	@RequestMapping(value = "/findByName" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody GenericContactResponse findByName(@RequestBody FindBynameMethodRequest request) {
		//Fetching Contact By Name
		contactRec = conDAO.findByName(request.getName());
		
		// Creating Response by checking conditions
		if (contactRec == null) {
			GenericContactResponse response = new GenericContactResponse(null,"Not Found");
			return response;		
		}		
		else {
			GenericContactResponse response = new GenericContactResponse(contactRec,"Record Found");
			return response;
		}

	}
	
	@RequestMapping(value = "/findByEmail" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody GenericContactResponse findByEmail(@RequestBody FindByemailMethodRequest request) {

		//Fetching Contact By Email
		
		contactRec= conDAO.findByEmail(request.getEmail());
		if (contactRec == null) {
			GenericContactResponse response = new GenericContactResponse(null,"Not Found");
			return response;		
		}		
		else {
			GenericContactResponse response = new GenericContactResponse(contactRec,"Record Found");
			return response;
		}
		
		
	}
	
	
	@RequestMapping(value = "/findAllByState" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody ContactsListResponse findAllByState(@RequestBody FindByStateMethodRequest request) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		
		List<Contact> contactList= conDAO.findByState(request.getState());
		
		if (contactList == null) {
			ContactsListResponse response = new ContactsListResponse(null,"Not Found");
			return response;		
		}		
		else {
			
			
				ContactsListResponse response = new ContactsListResponse(contactList,"Record Found");
				return response;
			}
		
		
	}
	

	@RequestMapping(value = "/DeleteContactByName" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody GenericResponse DeleteContactByName (@RequestBody FindBynameMethodRequest request) {
		
		contactRec = conDAO.findByName(request.getName());
		String result = conDAO.Remove(contactRec);
		
		
		if(result.contains("error")) {
			// Creating response based on the condition
			createMethodResponse = new GenericResponse("400" , "Bad Request or Backend Error", LocalDateTime.now().toString());
			//Response
			return  createMethodResponse;		
		}
		
		else {
		// Creating response based on the condition	
		createMethodResponse = new GenericResponse("200" , "Contact Removed Successfully", LocalDateTime.now().toString());
		//Response
		return  createMethodResponse;
		}		
		
	
	}
	

	
	@RequestMapping(value = "/updateContactByName" , method = RequestMethod.POST, produces= "application/json")
	public @ResponseBody GenericResponse updateContactByName (@RequestBody Contact request) {
		
		contactRec = conDAO.findByName(request.getName());
		request.setId(contactRec.getId());
		
		String result = conDAO.updateByName(request);
		
		
		if(result.contains("error")) {
			// Creating response based on the condition
			createMethodResponse = new GenericResponse("400" , "Bad Request or Backend Error", LocalDateTime.now().toString());
			//Response
			return  createMethodResponse;		
		}
		
		else {
		// Creating response based on the condition	
		createMethodResponse = new GenericResponse("200" , "Contact Updated Successfully", LocalDateTime.now().toString());
		//Response
		return  createMethodResponse;
		}		
		
	
	}
	
	
	
	
	
	

}
	
	
	
	
	
	
	
	
	

