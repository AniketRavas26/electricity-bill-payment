package com.ebp.in.service;

import java.util.Date;
import java.util.List;

import com.ebp.in.entity.Bill;
import com.ebp.in.entity.Reading;
import com.ebp.in.enums.ConnectionType;
import com.ebp.in.exception.InvalidReadingException;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;



public interface BillService {
	
	
	public Bill generateBill(Reading reading) throws InvalidReadingException;
	
	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchConnectionException;
	
	public Bill viewBillByMobileNumber(String mobile) throws NoSuchCustomerException;
	
	public Bill viewBillByEmail(String email) throws NoSuchCustomerException;
	
	public List<Bill> viewBillForDateRange(Date from, Date to) throws NoSuchCustomerException;
	
	public double energyBillCalculator(ConnectionType connectionType ,double units);
	
	public void emailBillToCustomer(Long consumerNumber, String email) throws NoSuchConnectionException;
	

}
