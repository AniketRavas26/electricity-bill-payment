package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.Customer;
import com.ebp.in.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	public Optional<Customer> readByEmail(String email);

	public Optional<Customer> readByAdharNumber(Long adharNumber);

	public Optional<Customer> readByMobileNumber(String mobileNumber);

	public List<Customer> readByFirstName(String firstName);

}
