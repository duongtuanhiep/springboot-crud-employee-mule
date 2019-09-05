package com.ci1802.springbootemployeemule.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ci1802.springbootemployeemule.model.enumclass.MainSecType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AddressClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int tableId;

	private MainSecType type;

	private String street;

	private String postalCode;
	
	private String city;
	
	private String county;
	
	private String country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_key")
	@JsonIgnore
	private Employee employee;
	
	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public MainSecType getType() {
		return type;
	}

	public void setType(MainSecType type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "AddressClass [tableId=" + tableId + ", type=" + type + ", street=" + street + ", postalCode="
				+ postalCode + ", city=" + city + ", county=" + county + ", country=" + country + ", employee="
				+ employee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tableId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressClass other = (AddressClass) obj;
		if (tableId != other.tableId)
			return false;
		return true;
	}
	
}
