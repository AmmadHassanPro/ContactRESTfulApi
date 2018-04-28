package com.restful.RestfulApi;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.DAO.ContactDAO;
import com.restful.Entities.Contact;
import com.restful.Requests.FindByemailMethodRequest;
import com.restful.Requests.FindBynameMethodRequest;
import com.restful.Responses.GenericResponse;


@SpringBootTest
public class ContactRestTests {
	@Autowired
	private ContactREST contactController;
	@Autowired
	private GenericResponse createmethodResponse;
	private Contact contact;
	private String jsonReq;
	private String jsonRes;
	private ObjectMapper mapper;
	private MockMvc mockMVC;
	
	private ContactREST restController;
	@Mock
	private ContactDAO dao;
	
	
	@Before
	public void setUP() throws JsonProcessingException {
		MockitoAnnotations.initMocks(this);
		
		contact = new Contact("name", "company", "image" ,"email ", "birthday","phoneWork","phonePersonal","streetAddress","city","state","zipcode");
		mapper = new ObjectMapper();
		jsonReq = mapper.writeValueAsString(contact);
		createmethodResponse = new GenericResponse("200" , "Contact Added Successfully", "Datetime"); // DateTime is left as is, because it will always be different
		jsonRes = mapper.writeValueAsString(createmethodResponse);
		restController = new ContactREST(dao);
		mockMVC = MockMvcBuilders.standaloneSetup(restController).build();
	
	}

	//A Test case for testing if the request is being passed in Create and if the status is ok as response
	@SuppressWarnings("deprecation")
	@Test
	public void StatusTestCase() throws Exception{
	 
		// Setting up up Mock Data
		
		when(dao.Save(Matchers.any(Contact.class))).thenReturn("saved");
	
	
	 
	mockMVC.perform(post("/Create").contentType(MediaType.APPLICATION_JSON).content(jsonReq)).andExpect(jsonPath("$.status" ,is("200")));//Will only check for status is ok i.e 200
	
	}  
	
	@Test
	public void getContactByName() throws Exception {
		String arg="name";
		
		FindBynameMethodRequest req = new FindBynameMethodRequest(arg);
		
		jsonReq = mapper.writeValueAsString(req);
		
		Contact mockContact = new Contact();
		mockContact.setName(arg);
		
		//when(dao.findByName(req.getName())).thenReturn(mockContact);
		when(dao.findByName(Matchers.anyString())).thenReturn(mockContact);
	
		
		mockMVC.perform(post("/findByName").contentType(MediaType.APPLICATION_JSON).content(jsonReq)).andExpect(jsonPath("$.status" ,is("Record Found")));//Will check if the record is found with the name
	}
	
	@Test
	public void getContactByEmail() throws Exception {
		String arg="email";
		
		FindByemailMethodRequest req = new FindByemailMethodRequest(arg);
		
		jsonReq = mapper.writeValueAsString(req);
		
		Contact mockContact = new Contact();
		mockContact.setEmail(req.getEmail());
		
		//when(dao.findByName(req.getName())).thenReturn(mockContact);
		when(dao.findByEmail(Matchers.anyString())).thenReturn(mockContact);
		
		mockMVC.perform(post("/findByEmail").contentType(MediaType.APPLICATION_JSON).content(jsonReq)).andExpect(jsonPath("$.status" ,is("Record Found")));//Will check if the record contains the name	
		
		
	}
	
	
	
}
