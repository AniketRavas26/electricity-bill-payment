package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebp.in.entity.Customer;
import com.ebp.in.entity.User;

public interface CustomerRepository extends JpaRepository<User,Long>{
	
	public Optional<Customer> readCustometByCustomerId(Long customerId);
	
	public Optional<Customer> readCustomerByEmail(String email);

	public Optional<Customer> readCustomerByAdharNumber(Long adharNumber);

	public Optional<Customer> readCustomerByMobileNumber(String mobileNumber);

	public List<Customer> readCustomerByFirstName(String firstName);

}
