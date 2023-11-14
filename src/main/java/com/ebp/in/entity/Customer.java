package com.ebp.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Customer extends User{
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int customerId;
	@Column(unique = true, nullable = false)
	@NotNull(message = "Aadhaar no is Required")
	private Long adharNumber;
	@NotEmpty(message = "Name is Required")
	private String firstName;
	private String middleName;
	@NotEmpty(message = "Name is Required")
	private String lastName;
	@Column(unique = true, nullable = false)
	@NotEmpty(message = "Mobile no is Required")
	private String mobileNumber;
	@Column(unique = true, nullable = false)
	@Email
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format")
	private String email;
	@Column
	private String gender;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Long getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", adharNumber=" + adharNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", gender=" + gender + "]";
	}
	public Customer(Long userId, String userName, String password, int customerId,
			@NotNull(message = "Aadhaar no is Required") Long adharNumber,
			@NotEmpty(message = "Name is Required") String firstName, String middleName,
			@NotEmpty(message = "Name is Required") String lastName,
			@NotEmpty(message = "Mobile no is Required") String mobileNumber,
			@Email @NotBlank @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format") String email,
			String gender) {
		super(userId, userName, password);
		this.customerId = customerId;
		this.adharNumber = adharNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long userId, String userName, String password) {
		super(userId, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
