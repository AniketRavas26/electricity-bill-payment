package com.ebp.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.ReadingService;



@RestController
@RequestMapping(value = "/reading")

public class ReadingController {

	@Autowired
	private ReadingService readingService;

	@PostMapping(value = "/submit")
	public ResponseEntity<Reading> selfSubmit(@RequestBody Reading reading) {
		System.out.println("Inside the submit");
		Reading reading1 = readingService.selfSubmit(reading);
		return new ResponseEntity<Reading>(reading1, HttpStatus.CREATED);
	}

	@GetMapping(value = "/consumerNumber/{consumerNumber}")
	public ResponseEntity<Reading> findMeterReadingByConsumerNumber(Long consumerNumber)
			throws NoSuchCustomerException {
		return new ResponseEntity<Reading>(readingService.findMeterReadingByConsumerNumber(consumerNumber),
				HttpStatus.OK);
	}
}
