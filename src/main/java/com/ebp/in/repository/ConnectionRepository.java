package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.Connection;



@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	@Query(value = "select o from Connection o where o.consumerNumber=?1")
	public Optional<Connection> findByConsumerNumber(Long consumerNumber);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.village=?1")
	public List<Connection> readActiveConnectionsByVillage(String village);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.village=?1")
	public List<Connection> readInActiveConnectionsByVillage(String village);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.taluka=?1")
	public List<Connection> readActiveConnectionsByTaluk(String taluka);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.taluka=?1")
	public List<Connection> readInActiveConnectionsByTaluk(String taluka);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.district=?1")
	public List<Connection> readActiveConnectionsByDistrict(String district);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.district=?1")
	public List<Connection> readInActiveConnectionsByDistrict(String district);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.pincode=?1")
	public List<Connection> readActiveConnectionsByPincode(String pincode);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.pincode=?1")
	public List<Connection> readInActiveConnectionsByPincode(String pincode);

	
}
