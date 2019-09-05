package com.ci1802.springbootemployeemule.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.ci1802.springbootemployeemule.model.enumclass.PhoneType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PhoneClass implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int tableId;
	
	private PhoneType phoneType;
	
	@Size(max = 40)
	private String phoneNumber ;
	
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

	public PhoneType getPhonetype() {
		return phoneType;
	}

	public void setPhonetype(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PhoneClass [tableId=" + tableId + ", phoneType=" + phoneType + ", phoneNumber=" + phoneNumber
				+ ", employee=" + employee + "]";
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
		PhoneClass other = (PhoneClass) obj;
		if (tableId != other.tableId)
			return false;
		return true;
	}
	
}
