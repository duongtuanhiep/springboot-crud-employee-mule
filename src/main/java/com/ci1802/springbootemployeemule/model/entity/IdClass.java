package com.ci1802.springbootemployeemule.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

import com.ci1802.springbootemployeemule.model.enumclass.MainSecType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IdClass  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int tableId;
	
	private MainSecType type;
	
	private String employeeId ;
	
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
		IdClass other = (IdClass) obj;
		if (tableId != other.tableId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IdClass [tableId=" + tableId + ", type=" + type + ", employeeId=" + employeeId + ", employee="
				+ employee + "]";
	}
	
}
