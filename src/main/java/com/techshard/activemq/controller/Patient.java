package com.techshard.activemq.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient {
	
	private String city;
	private String country;
	private String email;
	private String firstName;
	private String lastName;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonCreator
	public Patient(@JsonProperty("city")  String city,@JsonProperty("country")  String country,@JsonProperty("email")  String email,@JsonProperty("firstName")  String firstName,@JsonProperty("lastName")  String lastName) {
		super();
		this.city = city;
		this.country = country;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

}
