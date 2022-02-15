package com.example.CompanyAPI.dto;

import com.example.CompanyAPI.model.Company;

public class CompanyDTO {

	private String id;
	private String NameComp;
	private String EmailComp;
	private long PhoneNumber;
	private long NumberOfEmployees;
	
	
	public CompanyDTO( String id, String nameComp, String emailComp, long phoneNumber, long numberOfEmployees) {
		super();
		this.id=id;
		this.NameComp = nameComp;
		this.EmailComp = emailComp;
		this.PhoneNumber = phoneNumber;
		this.NumberOfEmployees = numberOfEmployees;
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

	public Company convertToCompany() {
		return new Company(id,NameComp, EmailComp, PhoneNumber ,NumberOfEmployees);
	}
	
	public CompanyDTO build(Company company) {
		return new CompanyDTO(company.getId(), company.getNameComp(),company.getEmailComp(),company.getPhoneNumber(),company.getNumberOfEmployees());
	}



}
