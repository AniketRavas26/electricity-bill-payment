package com.ebp.in.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Connection;
import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.ReadingRepository;



@Service
public class ReadingServiceImpl implements ReadingService {

	@Autowired
	private ReadingRepository read;

	@Autowired
	private BillService billService;
	
	/*
	 * We are generating the reading
	 */
	@Override
	public Reading selfSubmit(Reading reading) {
		Double pricePerUnit = reading.getPricePerUnits();
		Reading reading1 = null;
		Connection existingConnection = reading.getReadingForConnection();
		Long connectionId = existingConnection.getConnectionId();
		if (connectionId == 0) {
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = read.save(reading);
			
		} else {
			reading.setReadingForConnection(existingConnection);
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = read.save(reading);
			
		}

		return reading1;
	}

	/*
	 * We are searching the meter reading by taking the consumer number,
	 * If consumer number does not exists throws No such customer exception
	 */
	@Override
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return read.findMeterReadingByConsumerNumber(consumerNumber)
				.orElseThrow(() -> new NoSuchCustomerException("Customer Not Exist!"));
	}

}
