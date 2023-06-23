/**
 * 
 */
package com.veeru.spring.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Virupaksha K
 *
 */
@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private Double salary;
	private String emailId;
	private Long mobileNo;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;

	public Employee() {
		
	}

	public Employee(Integer id, String firstName, String lastName, Double salary, String emailId, Long mobileNo,
			Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public String getEmailId() {
		return emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
