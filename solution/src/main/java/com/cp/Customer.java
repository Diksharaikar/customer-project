package com.cp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_fName")
    private String customerFname;
    @Column(name = "customer_mName")
    private String customerMname;
    @Column(name = "customer_lName")
    private String customerLname;
    @Column(name = "customer_mobile")
    private long mobile;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_lAddress")
    private String lAddress;
    @Column(name = "customer_lAddress_dist")
    private String lAddressDist;
    @Column(name = "customer_lAddress_state")
    private String lAddressState;
    @Column(name = "customer_lAddress_country")
    private String lAddressCountry;
    @Column(name = "customer_pAddress")
    private String pAddress;
    @Column(name = "customer_pAddress_dist")
    private String pAddressDist;
    @Column(name = "customer_pAddress_state")
    private String pAddressState;
    @Column(name = "customer_pAddress_country")
    private String pAddressCountry;
    @Column(name = "customer_status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public void setCustomerMname(String customerMname) {
        this.customerMname = customerMname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setlAddress(String lAddress) {
        this.lAddress = lAddress;
    }

    public void setlAddressDist(String lAddressDist) {
        this.lAddressDist = lAddressDist;
    }

    public void setlAddressState(String lAddressState) {
        this.lAddressState = lAddressState;
    }

    public void setlAddressCountry(String lAddressCountry) {
        this.lAddressCountry = lAddressCountry;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setpAddressDist(String pAddressDist) {
        this.pAddressDist = pAddressDist;
    }

    public void setpAddressState(String pAddressState) {
        this.pAddressState = pAddressState;
    }

    public void setpAddressCountry(String pAddressCountry) {
        this.pAddressCountry = pAddressCountry;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public String getCustomerMname() {
        return customerMname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public long getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getlAddress() {
        return lAddress;
    }

    public String getlAddressDist() {
        return lAddressDist;
    }

    public String getlAddressState() {
        return lAddressState;
    }

    public String getlAddressCountry() {
        return lAddressCountry;
    }

    public String getpAddress() {
        return pAddress;
    }

    public String getpAddressDist() {
        return pAddressDist;
    }

    public String getpAddressState() {
        return pAddressState;
    }

    public String getpAddressCountry() {
        return pAddressCountry;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerFname='" + customerFname + '\'' +
                ", customerMname='" + customerMname + '\'' +
                ", customerLname='" + customerLname + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", lAddress='" + lAddress + '\'' +
                ", lAddressDist='" + lAddressDist + '\'' +
                ", lAddressState='" + lAddressState + '\'' +
                ", lAddressCountry='" + lAddressCountry + '\'' +
                ", pAddress='" + pAddress + '\'' +
                ", pAddressDist='" + pAddressDist + '\'' +
                ", pAddressState='" + pAddressState + '\'' +
                ", pAddressCountry='" + pAddressCountry + '\'' +
                ", status=" + status +
                '}';
    }
}
