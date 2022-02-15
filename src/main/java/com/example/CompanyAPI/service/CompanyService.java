package com.example.CompanyAPI.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CompanyAPI.dto.CompanyDTO;

public interface CompanyService {

public List<CompanyDTO> getAllCompanies();
	
	public CompanyDTO getCompanyById(@PathVariable(value = "id") String id);
	
	public CompanyDTO createCompany(@Valid @RequestBody CompanyDTO Companydto);
	
	public void UpdateCompany (@PathVariable (value="id") String id, @RequestBody CompanyDTO companyDetails) ;
	
	public String DeleteCompany(@PathVariable (value="id") String id) ;
}
