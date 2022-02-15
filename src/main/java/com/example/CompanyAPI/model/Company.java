package com.example.CompanyAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.example.CompanyAPI.dto.CompanyDTO;

@Document(collection="companies")
public class Company {

	@Id
	private String id;
	
	private String NameComp;

	private String EmailComp;
	
	private long PhoneNumber;
	
	private long NumberOfEmployees;
	
	
	public Company() {
		super();
	}

	public Company(String id, String NameComp, String EmailComp, long PhoneNumber, long NumberOfEmployees) {
		super();
		this.id = id;
		this.NameComp = NameComp;
		this.EmailComp = EmailComp;
		this.PhoneNumber = PhoneNumber;
		this.NumberOfEmployees = NumberOfEmployees;
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
		this.NameComp = nameComp;
	}

	

	public String getEmailComp() {
		return EmailComp;
	}

	public void setEmailComp(String emailComp) {
		this.EmailComp = emailComp;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public long getNumberOfEmployees() {
		return NumberOfEmployees;
	}

	public void setNumberOfEmployees(long numberOfEmployees) {
		this.NumberOfEmployees = numberOfEmployees;
	}

	public CompanyDTO convertToDto() {
		return new CompanyDTO(id,NameComp, EmailComp, PhoneNumber,NumberOfEmployees);
	}
	
	public Company updateFromDto(CompanyDTO companyDto) {
		this.setId(companyDto.getId());
		this.setNameComp(companyDto.getNameComp());
		this.setEmailComp(companyDto.getEmailComp());
		this.setPhoneNumber(companyDto.getPhoneNumber());
		this.setNumberOfEmployees(companyDto.getNumberOfEmployees());

		return this;
	}
//	 @Override
//	  public String toString() {
//	    return String.format(
//	        "Customer[id=%d, NameComp='%s', EmailComp='%s',PhoneNumber='%d',NumberOfEmployees='%d']",
//	        id, NameComp, EmailComp,PhoneNumber,NumberOfEmployees);
//	  }

}
