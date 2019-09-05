package com.ci1802.springbootemployeemule.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.ci1802.springbootemployeemule.model.enumclass.HrStatus;
import com.ci1802.springbootemployeemule.model.enumclass.PoiType;
import com.ci1802.springbootemployeemule.model.enumclass.Sex;


	/** 
	 * JsonIgnoreProperties was first enabled to avoid bugs similar to following links : 
	http://www.greggbolinger.com/ignoring-hibernate-garbage-via-jsonignoreproperties/
	https://hibernate.atlassian.net/browse/OGM-641?attachmentOrder=desc
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	*/
@Entity
public class Employee implements Serializable{

	/**
	 * Implementing Serializable to transfer across the internet
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Define the properties of the entity 
	 * String id is set to be the primary key of the table with the annotation @Id
	 */
	@Id
	@Column(name = "key")
	@Size(min = 1, max = 11)
	private String key;
	
	@NotNull 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<IdClass> IDs = new HashSet<>();
	
	@NotNull 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<PhoneClass> Phones = new HashSet<>();

	@NotNull 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<EmailClass> Emails = new HashSet<>();
	
	@NotNull 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<AddressClass> Addresses = new HashSet<>();
	
	@NotNull 
	private Sex sex;

	@NotNull 
	@Size(min = 2, max = 30)
	private String titleName;
	
	@NotNull 
	@Size(min = 2, max = 30)
	private String firstName;

	@NotNull 
	@Size(min = 2, max = 30)
	private String lastName;
	
	@NotNull 
	private PoiType poiType;
	
	@NotNull 
	private HrStatus hrStatus;
	
	@Size(min = 2, max = 30)
	private String alias;

	@NotNull 
	@Email
	private String emailAddress;

	@Past
	private LocalDateTime lastChangedDate;
	
	//SETTER AND GETTER

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Set<IdClass> getIDs() {
		return IDs;
	}

	public void setIDs(Set<IdClass> iDs) {
		IDs = iDs;
	}

	public Set<PhoneClass> getPhones() {
		return Phones;
	}

	public void setPhones(Set<PhoneClass> phones) {
		Phones = phones;
	}

	public Set<EmailClass> getEmails() {
		return Emails;
	}

	public void setEmails(Set<EmailClass> emails) {
		Emails = emails;
	}

	public Set<AddressClass> getAddresses() {
		return Addresses;
	}

	public void setAddresses(Set<AddressClass> addresses) {
		Addresses = addresses;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PoiType getPoiType() {
		return poiType;
	}

	public void setPoiType(PoiType poiType) {
		this.poiType = poiType;
	}

	public HrStatus getHrStatus() {
		return hrStatus;
	}

	public void setHrStatus(HrStatus hrStatus) {
		this.hrStatus = hrStatus;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public LocalDateTime getLastChangedDate() {
		return lastChangedDate;
	}

	public void setLastChangedDate(LocalDateTime lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}


	@Override
	public String toString() {
		return "Employee [key=" + key + ", IDs=" + IDs + ", Phones=" + Phones + ", Emails=" + Emails + ", Addresses="
				+ Addresses + ", sex=" + sex + ", titleName=" + titleName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", poiType=" + poiType + ", hrStatus=" + hrStatus + ", alias=" + alias + ", emailAddress="
				+ emailAddress + ", lastChangedDate=" + lastChangedDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Employee other = (Employee) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}