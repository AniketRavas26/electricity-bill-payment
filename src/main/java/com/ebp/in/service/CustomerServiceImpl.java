package com.ebp.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Customer;
import com.ebp.in.exception.DuplicateCustomerException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerProfile(int customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return searchCustomerByCustomerId((long) customerId);
	}

	@Override
	public Customer editCustomerProfile(int customerId, Customer customer) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return (Customer) customerRepository.findById(customerId)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByAdhaar(Long adharNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findByAdharNumber(adharNumber)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByMobile(String mobile) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findByMobileNumber(mobile)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public List<Customer> searchCustomerByName(String customerName) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		try {
			List<Customer> byName = customerRepository.findByFirstName(customerName);
			return byName;
		} catch (Exception e) {
			throw new NoSuchCustomerException("Customer with name:" + customerName + "not present");
		}

	}

}
