package com.ci1802.springbootemployeemule.searchapi;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.ConversionService;

public class SearchFieldExtractor<T> {
	private Class<T> domainType;
	private Map<String, Class<?>> searchableFieldMap;
	//Implement an arraylist
	private List<SearchCriteria> searchCriteriaParams = new ArrayList<SearchCriteria>();
	
	//Constructor that collect all field of a entity class
	// Example : Map<String, Field> searchFields = new SearchFieldExtractor<>(Employee.class)
	public SearchFieldExtractor(Class<T> domainType) {
	  this.domainType = domainType;
    }
	
	public Map<String, Class<?>> getSearchableFieldMap() {
		  Map<String, Class<?>> fields = new HashMap<String, Class<?>>();
		  for (Field field : domainType.getDeclaredFields()) {
		    if (!fields.containsKey(field.getName())) {
		      fields.put(field.getName(), field.getType());
		    }
		  }
		  this.searchableFieldMap = fields;
		  return searchableFieldMap;
	}

	public List<SearchCriteria> getSearchCriteriaParams() {
		return searchCriteriaParams;
	}

	public void setSearchCriteriaParams(List<SearchCriteria> searchCriteriaParams) {
		this.searchCriteriaParams = searchCriteriaParams;
	}	
}