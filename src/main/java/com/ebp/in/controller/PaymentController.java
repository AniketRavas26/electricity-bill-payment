package com.ebp.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebp.in.entity.Payment;
import com.ebp.in.enums.PaymentStatus;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.PaymentService;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping(value = "/payBill")
	public ResponseEntity<PaymentStatus> payBill(@RequestBody Payment payment)
	{
		PaymentStatus paymentStatus= paymentService.payBill(payment);
		
		return new ResponseEntity<PaymentStatus>(paymentStatus, HttpStatus.CREATED);
	}

	@GetMapping(value="/consumerNumber/{consumerNumber}")
	public ResponseEntity<List<Payment>> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException
	{
		List<Payment> readByconsumerNumber=paymentService.viewHistoricalPayment(consumerNumber);
		return new ResponseEntity<List<Payment>>(readByconsumerNumber,HttpStatus.OK);				
	}
	
	@GetMapping("/sendEmailOnPaymentCompletion")
	public ResponseEntity<?> sendEmailOnPaymentCompletion(@RequestParam Long consumerId, @RequestParam String email){
		paymentService.sendEmailOnPaymentCompletion(consumerId, email);
		return new ResponseEntity<>("Payment was Successufully" + email, HttpStatus.OK);
	}
}
