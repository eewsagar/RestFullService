package com.rest.webservice.restfulwebservice.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.impl.*;

@RestController
public class FiltteringControler {

	//filed1, filed2
	
	@GetMapping("/filtering")
	public MappingJacksonValue  retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		Set<String> sets = new HashSet<String>();
		sets.add("field1");
		sets.add("field2");
		
		SimpleBeanPropertyFilter filter =  new SimpleBeanPropertyFilter.FilterExceptFilter(sets);
		
		FilterProvider filters =  new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		MappingJacksonValue mapping =  new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	//filed2, filed3
	@GetMapping("/filtering-list")
	public MappingJacksonValue  retrieveListOfSomeBean() {
		
		List<SomeBean> list =  Arrays.asList(new  SomeBean("value1","value2","value3"),
				new  SomeBean("value12","value22","value32"));
		
		Set<String> sets = new HashSet<String>();
		sets.add("field2");
		sets.add("field3");
		
		SimpleBeanPropertyFilter filter =  new SimpleBeanPropertyFilter.FilterExceptFilter(sets);
		
		FilterProvider filters =  new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		MappingJacksonValue mapping =  new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}
}
