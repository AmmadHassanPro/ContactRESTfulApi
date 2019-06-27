package com.restful.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restful.Entities.Contact;
import com.restful.Persistence.ContactPersistence;

/*
 * This class the representation of Data Access Layer for Contact Entity
 * 
 */
@Service
public class ContactDAO {
	@Autowired
	private ContactPersistence persistence;
	
	private Contact contactRec;
	
	public String Save(Contact cont) {
		try {
		this.persistence.save(cont);
		}
		// Catching exceptions
		catch(RuntimeException re) {
			
			return "error";
		}	
		catch(Exception e) {
			
			return "error";
		}
		return "saved";	
	}
	
	
	public Contact findByName(String name) {
		
		Contact contact;
		contact = this.persistence.findByName(name);
		
		return contact;

	}
	
	public Contact findByEmail(String Email) {
		
		Contact contact;
		
		contact= this.persistence.findByEmail(Email);
		return contact;
	}
	
	
	public List<Contact> findByState(String State){
	
		
		List<Contact> contactList = this.persistence.findByState(State);
		return contactList;
		
		
	}
	
	
	public String Remove(Contact contact) {
		
		try {
			this.persistence.delete(contact);;
			}
			// Catching exceptions
			catch(RuntimeException re) {
				
				return "error";
			}	
			catch(Exception e) {
				
				return "error";
			}
			return "Deleted Sucessfully!";	
	}
	
	
	public String updateByName(Contact contact) {
		try {
			this.persistence.save(contact);
			}
			// Catching exceptions
			catch(RuntimeException re) {
				
				return "error";
			}	
			catch(Exception e) {
				
				return "error";
			}
			return "Upddated Sucessfully!";	
		
		
	}


	public List<Contact> findAllByName(String name) {
		return persistence.findAllByName(name);
	}
	
	


}
