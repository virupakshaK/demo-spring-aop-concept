package com.veeru.spring.dto;

/**
 * @author Virupaksha K
 *
 */
public class EmployeeDTO {

	private Integer empId;
	private String firstName;
	private String lastName;
	private Double salary;
	private String emailId;
	private Long mobileNo;
	private AddressDTO addressDTO;

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Integer empId, String firstName, String lastName, Double salary, String emailId, Long mobileNo,
			AddressDTO addressDTO) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.addressDTO = addressDTO;
	}

	public Integer getEmpId() {
		return empId;
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

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", addressDTO=" + addressDTO + "]";
	}

}
