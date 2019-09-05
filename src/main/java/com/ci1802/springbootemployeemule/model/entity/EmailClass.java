package com.ci1802.springbootemployeemule.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmailClass  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int tableId;
	
	@Size(max = 70)
	@Email
	private String emailAddress;
	
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
		EmailClass other = (EmailClass) obj;
		if (tableId != other.tableId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailClass [tableId=" + tableId + ", emailAddress=" + emailAddress + ", employee=" + employee + "]";
	}
		
}
