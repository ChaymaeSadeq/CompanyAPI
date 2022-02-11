package com.example.CompanyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyAPI.exception.ResourceNotFound;
import com.example.CompanyAPI.model.Company;
import com.example.CompanyAPI.repository.CompanyRepository;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api2")
public class CompanyController {

	@Autowired
	private CompanyRepository CompanyRep;
	
	//Get all companies
	@GetMapping("/companies")
	public List<Company> GetAllCompanies(){
		System.out.println("Hello from Get");
		return CompanyRep.findAll();
		
	}
	
	//Get company by id
	@GetMapping("/companies/{id}")
	public ResponseEntity <Company> GetCompanyById(@PathVariable String id) throws ResourceNotFound {
		System.out.println("Hello from GETBYID");
		Company company=CompanyRep.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Company with id = "	+ id + " was not found"));		
		return ResponseEntity.ok().body(company);
		
	}
	
	//Create company
	@PostMapping("companies")
	public Company CreateCompany(@Valid @RequestBody Company company) {
		System.out.println("Hello from POST");
		return CompanyRep.save(company);
		
	}
	
	@RequestMapping(value = "/companies/{id}", 
	  produces = "application/json", 
	  method=RequestMethod.PUT)
//	@PutMapping(name="/employees/{id}")
	public ResponseEntity<Company> UpdateEmployee(@PathVariable (value="id") String id, @RequestBody Company companyDetails) throws ResourceNotFound {
		System.out.println("Hello from PUT");
		Company company= CompanyRep.findById(id).orElseThrow(()->new ResourceNotFound("Employee with id = "	+ id + " was not found"));
		company.setNameComp(companyDetails.getNameComp());
		company.setEmailComp(companyDetails.getEmailComp());
		company.setPhoneNumber(companyDetails.getPhoneNumber());
		company.setNumberOfEmployees(companyDetails.getNumberOfEmployees());		
		CompanyRep.save(company);
		return ResponseEntity.ok().body(company);
	}
	
	//Delete company
	@DeleteMapping("/companies/{id}")
	public String DeleteCompany(@PathVariable String id) {
		CompanyRep.deleteById(id);
		return "Company deleted with id : " + id;
	}
}

