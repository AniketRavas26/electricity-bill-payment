package com.ebp.in.service;

import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;

public interface ReadingService {
	
	public Reading selfSubmit(Reading reading);
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;
	//public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, Date billDate)throws NoSuchCustomerException;
}



