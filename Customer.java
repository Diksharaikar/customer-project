package com.ty;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String localAddress;
    private String localAddressDistrict;
    private String localAddressState;
    private String permanentAddress;
    private String permanentCountry;
    private String permanentState;
    private String permanentDistrict;
    private String status;
	public Customer(Long id, String firstName, String middleName, String lastName, String mobileNumber, String emailId,
			String localAddress, String localAddressDistrict, String localAddressState, String permanentAddress,
			String permanentCountry, String permanentState, String permanentDistrict, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.localAddress = localAddress;
		this.localAddressDistrict = localAddressDistrict;
		this.localAddressState = localAddressState;
		this.permanentAddress = permanentAddress;
		this.permanentCountry = permanentCountry;
		this.permanentState = permanentState;
		this.permanentDistrict = permanentDistrict;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getLocalAddressDistrict() {
		return localAddressDistrict;
	}
	public void setLocalAddressDistrict(String localAddressDistrict) {
		this.localAddressDistrict = localAddressDistrict;
	}
	public String getLocalAddressState() {
		return localAddressState;
	}
	public void setLocalAddressState(String localAddressState) {
		this.localAddressState = localAddressState;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public String getPermanentState() {
		return permanentState;
	}
	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}
	public String getPermanentDistrict() {
		return permanentDistrict;
	}
	public void setPermanentDistrict(String permanentDistrict) {
		this.permanentDistrict = permanentDistrict;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}