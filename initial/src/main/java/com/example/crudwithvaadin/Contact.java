package com.example.crudwithvaadin;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	private String emailId;
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private String firstName;

	private String lastName;

	private Long phoneNumber;
	
	private boolean status=false;
	public Contact(String emailId, String firstName, String lastName, Long phoneNumber, boolean status) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Contact [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", status=" + status + "]";
	}
	
	public Contact()
	{
		
	}
	HashSet<E>
}
