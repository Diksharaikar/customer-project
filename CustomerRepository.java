package com.ty;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods here if needed
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByMiddleName(String middleName);
	List<Customer> findByLastName(String lastName);
	List<Customer> findByMobileNumber(String mobileNumber);
	List<Customer> findByEmailId(String emailId);
	List<Customer> findByLocalAddress(String localAddress);
	List<Customer> findByLocalAddressDistrict(String localAddressDistrict);
	List<Customer> findByLocalAddressState(String localAddressState);
	List<Customer> findByPermanentAddress(String permanentAddress);
	List<Customer> findByPermanentCountry(String permanentCountry);
	List<Customer> findByPermanentState(String permanentState);
	List<Customer> findByPermanentDistrict(String permanentDistrict);
	List<Customer> findByStatus(String status);
	
}


