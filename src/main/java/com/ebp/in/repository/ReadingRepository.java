package com.ebp.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebp.in.entity.Reading;



public interface ReadingRepository extends JpaRepository<Reading, Long> {

	@Query(value = "select o from Reading o where o.readingForConnection.consumerNumber=?1")
	public Optional<Reading> findMeterReadingByConsumerNumber(Long consumerNumber);

}
