package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.Customer;
import com.ebp.in.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	public Optional<Customer> readCustometByCustomerId(Long customerId);
	
	public Optional<Customer> readCustomerByEmail(String email);
	
	public Optional<Customer> readCustomerByAdharNumber(Long adharNumber);
	
	public Optional<Customer> readCustomerByMobileNumber(String mobileNumber);
	
	public List<Customer> readCustomerByFirstName(String firstName);

}
