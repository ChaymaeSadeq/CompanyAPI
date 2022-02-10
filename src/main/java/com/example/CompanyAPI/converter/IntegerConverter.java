package com.example.CompanyAPI.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

public abstract class IntegerConverter implements Converter<ObjectId, Long> {
	
	public Long convert(Long source) {
		
		return source;
		}
}