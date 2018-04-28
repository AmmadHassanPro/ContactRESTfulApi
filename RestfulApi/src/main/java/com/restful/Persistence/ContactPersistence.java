package com.restful.Persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.restful.Entities.Contact;


public interface ContactPersistence extends CrudRepository<Contact,Long>{
	
	Contact findByName(String name);
	Contact findByEmail(String email);
	
	List<Contact> findByState(String State);

}
