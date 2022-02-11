package com.example.CompanyAPI.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.CompanyAPI.model.Company;

public interface CompanyRepository extends MongoRepository<Company, String>{

}

