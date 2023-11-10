package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebp.in.entity.Customer;
import com.ebp.in.entity.User;

public interface CustomerRepository extends JpaRepository<User,Long>{
	public Optional<Customer> findByEmail(String email);

	public Optional<Customer> findByAdharNumber(Long adharNumber);

	public Optional<Customer> findByMobileNumber(String mobileNumber);

	public List<Customer> findByFirstName(String firstName);

}
