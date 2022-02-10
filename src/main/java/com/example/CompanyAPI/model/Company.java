package com.example.CompanyAPI.model;


import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="companies")
public class Company {

	@Id
	private String id;
	private String NameComp;
	private String EmailComp;
	private long PhoneNumber;
	private long NumberOfEmployees;
	
	
	public Company( String nameComp, String emailComp, long phoneNumber, long numberOfEmployees) {
		super();
		NameComp = nameComp;
		EmailComp = emailComp;
		PhoneNumber = phoneNumber;
		NumberOfEmployees = numberOfEmployees;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getNameComp() {
		return NameComp;
	}

	public void setNameComp(String nameComp) {
		NameComp = nameComp;
	}

	public Company() {
		super();
	}

	public String getEmailComp() {
		return EmailComp;
	}

	public void setEmailComp(String emailComp) {
		EmailComp = emailComp;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public long getNumberOfEmployees() {
		return NumberOfEmployees;
	}

	public void setNumberOfEmployees(long numberOfEmployees) {
		NumberOfEmployees = numberOfEmployees;
	}

//	 @Override
//	  public String toString() {
//	    return String.format(
//	        "Customer[id=%d, NameComp='%s', EmailComp='%s',PhoneNumber='%d',NumberOfEmployees='%d']",
//	        id, NameComp, EmailComp,PhoneNumber,NumberOfEmployees);
//	  }

}
