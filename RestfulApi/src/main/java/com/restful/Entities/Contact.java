package com.restful.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Contact {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String company;
	private String image; // Base64 representation of image
	private String email;
	//private String birthday;
	private String birthday;
	private String phoneWork;
	private String phonePersonal;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	public Contact() {}
	

	
	public Contact(String name, String company, String image, String email, String birthday, String phoneWork,
			String phonePersonal, String streetaddress, String city, String state, String zipecode) {
		super();
		this.name = name;
		this.company = company;
		this.image = image;
		this.email = email;
		this.birthday = birthday;
		this.phoneWork = phoneWork;
		this.phonePersonal = phonePersonal;
		this.streetAddress = streetaddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipecode;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	public String getPhonePersonal() {
		return phonePersonal;
	}
	public void setPhonePersonal(String phonePersonal) {
		this.phonePersonal = phonePersonal;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetaddress) {
		this.streetAddress = streetaddress;
	}

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipecode) {
		this.zipcode = zipecode;
	}
	public Long getId() {
		
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

}
