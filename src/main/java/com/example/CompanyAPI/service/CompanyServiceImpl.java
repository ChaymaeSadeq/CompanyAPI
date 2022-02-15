package com.example.CompanyAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CompanyAPI.dto.CompanyDTO;
import com.example.CompanyAPI.model.Company;
import com.example.CompanyAPI.repository.CompanyRepository;

public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRep;
	
	@Override
	public List<CompanyDTO> getAllCompanies() {
		System.out.println("Hello from GET Company");
		List<Company> company = companyRep.findAll();
		List<CompanyDTO> companydto = new ArrayList<>();
		for (Company c: company) {
			companydto.add(new CompanyDTO(c.getId(),c.getNameComp(), c.getEmailComp(), c.getPhoneNumber(),c.getNumberOfEmployees()));
		}

		return companydto;
	}

	@Override
	public CompanyDTO getCompanyById(@PathVariable(value = "id") String id) {
		System.out.println("Hello from GETBYID Company");
		Optional<Company> company = companyRep.findById(id);
		CompanyDTO comp= new CompanyDTO(company.get().getId() , company.get().getNameComp(), company.get().getEmailComp(), 
				company.get().getPhoneNumber(),company.get().getNumberOfEmployees());
			return comp;
	}

	@Override
	public CompanyDTO createCompany(@Valid CompanyDTO Companydto) {
		System.out.println("Hello from POST Company");
		Company company = companyRep.save(Companydto.convertToCompany());
		return company.convertToDto();	
	}

	@Override
	public void UpdateCompany(@PathVariable (value="id") String id, @RequestBody CompanyDTO companydto) {
		System.out.println("Hello from PUT Comany");
		Optional<Company> company = companyRep.findById(companydto.getId());
			Company newemcompany = company.get().updateFromDto(companydto);
			Company savedcompany = companyRep.save(newemcompany);
			savedcompany.convertToDto();		
	}

	@Override
	public String DeleteCompany(@PathVariable (value="id") String id) {
		System.out.println("Hello from DELETE Comany");
		companyRep.existsById(id);
		companyRep.deleteById(id);
		
		return "Employee deleted with id : " + id;
	}

}
