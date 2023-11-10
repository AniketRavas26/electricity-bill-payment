package com.ebp.in.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Bill;
import com.ebp.in.entity.Reading;
import com.ebp.in.enums.ConnectionType;
import com.ebp.in.exception.InvalidReadingException;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.BillRepository;



@Service
public class BillServiceImpl implements BillService {
		@Autowired
		private BillRepository billRepository;
	
		@Autowired
		private ReadingRepository readingRepository;
	
		/*
		 * Method to Generate Bill from a Reading Object,
		 * if reading object is invalid it throws an User Defined Exception 
		 * 
		 */
		@Override
		public Bill generateBill(Reading reading) throws InvalidReadingException {
			Bill bill = new Bill();
			Bill generatedBill = null;
			try {
			Long readingId = reading.getReadingId();
			Reading existingReading = readingRepository.findById(readingId).get();
			Double pricePerUnit = existingReading.getPricePerUnits();
			Double unitsConsumed = existingReading.getUnitsConsumed();
			bill.setBillDate(new Date());
			LocalDate d= LocalDate.now().plusDays(20);
			bill.setBillDueDate(d);
			bill.setBillForReading(existingReading);
			bill.setUnitsConsumed(unitsConsumed);
			bill.setBillAmount(pricePerUnit * unitsConsumed);
			generatedBill=billRepository.save(bill);
			}
			catch(Exception e){
				throw new InvalidReadingException("Invalid Reading is Provided");
			}
			return generatedBill;
		}
		
		
		@Override
		public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchConnectionException {
			return billRepository.viewBillByConsumerNumber(consumerNumber)
					.orElseThrow(() -> new NoSuchConnectionException("No Connection Exist!"));
	
		}
		
		@Override
		public Bill viewBillByMobileNumber(String mobileNumber) throws NoSuchCustomerException {
			return billRepository.viewBillByMobileNumber(mobileNumber)
					.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
		}
		
		@Override
		public Bill viewBillByEmail(String email) throws NoSuchCustomerException {
			return billRepository.viewBillByEmail(email)
					.orElseThrow(() -> new NoSuchCustomerException("Bill Is Not available for given email :" + email));
		}
		
		
		
		@Override
		public List<Bill> viewBillForDateRange(Date from, Date to) throws NoSuchCustomerException {
			try {
				return billRepository.findAllByBillDateBetween(from, to);
			} catch (Exception e) {
				throw new NoSuchCustomerException("Bill Is Not Available For Date from" + from + "to" + to);
			}
		}
		
		
		@Override
		public void emailBillToCustomer(Long consumerNumber, String email) throws NoSuchConnectionException {
			
			System.out.println(("email bill to customer" + viewBillByConsumerNumber(consumerNumber)));
	
		}
		
		@Override
		public double energyBillCalculator(ConnectionType connectionType, double units) {
			
			if(connectionType==ConnectionType.AGRICULTURAL) {
				return units*5;
			}
			if(connectionType==ConnectionType.INDUSTRIAL) {
				return units*8;
			}
			else {
				return units*6;
			}
		}

}
