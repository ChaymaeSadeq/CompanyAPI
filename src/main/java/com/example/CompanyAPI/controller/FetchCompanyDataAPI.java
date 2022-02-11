package com.example.CompanyAPI.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.CompanyAPI.model.Company;

@RestController
@RequestMapping("/api3")
public class FetchCompanyDataAPI {
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public static RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	private static final String GET_ALL_COMPANIES_API="http://localhost:8080/api2/companies";
	private static final String CREATE_COMPANIES_API="http://localhost:8080/api2/companies";
	private static final String UPDATE_COMPANIES_API="http://localhost:8080/api2/companies/{id}";
	private static final String DELETE_COMPANIES_API="http://localhost:8080/api2/companies/{id}";

	
//	@GetMapping("/companies")
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public List<Object> GetCompanies(){
		Object[] companies=restTemplate.getForObject(GET_ALL_COMPANIES_API, Object[].class, null, null);
		System.out.println("Get Companies from FetchData API");
		return Arrays.asList(companies);
		
	}
	
	@PostMapping("/companies")
	public ResponseEntity<Company> CreateEmployee(@RequestBody Company companyDetails) {
		
		HttpHeaders headers = new HttpHeaders();
		   headers.setContentType(MediaType.APPLICATION_JSON);
		   Company company = new Company();
		   company.setNameComp(companyDetails.getNameComp());
		   company.setEmailComp(companyDetails.getEmailComp());
		   company.setPhoneNumber(companyDetails.getPhoneNumber());
		   company.setNumberOfEmployees(companyDetails.getNumberOfEmployees());
		   HttpEntity<Company> requestEntity = new HttpEntity<Company>(company, headers);
		   URI uri = restTemplate.postForLocation(CREATE_COMPANIES_API, requestEntity);
		   
		   return ResponseEntity.ok().body(company);
	} 

//	@PutMapping("/companies/{id}")
//    private ResponseEntity<Employee> updateEmployee(@PathVariable (value="id") Long employeeId, @RequestBody Employee employeeDetails) {
//		
//		  HttpHeaders headers = new HttpHeaders();
//		  headers.setContentType(MediaType.APPLICATION_JSON);
//		  Employee employee = new Employee();
//		  employee.setFirstname(employeeDetails.getFirstname());
//		  employee.setLastname(employeeDetails.getLastname());
//		  employee.setEmailId(employeeDetails.getEmailId());
//		  HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee, headers);
//		  restTemplate.put(UPDATE_EMPLOYEE_API, requestEntity);
//        
//		return ResponseEntity.ok().body(employee);
//    }

//	@DeleteMapping("/employees/{id}")
//    private ResponseEntity deleteEmployee() {
//		System.out.println("Hello from DELETE");
//		 HttpHeaders headers = new HttpHeaders();
//		  headers.setContentType(MediaType.APPLICATION_JSON);
//		   Employee employee = new Employee();
//		  HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(headers);
//		  restTemplate.exchange(DELETE_EMPLOYEE_API, HttpMethod.DELETE, requestEntity, Void.class, 101); 
//		  return ResponseEntity.ok().body(employee);
//    }
	
	
//	public static void main(String[] args) {
//		SpringApplication.run(FetchEmployeeDataAPI.class, args);
//		System.out.println("Welcome to fetch Data API");
//	}
	
}
