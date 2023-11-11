package com.ebp.in.service;

import java.util.List;

import com.ebp.in.entity.Connection;
import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;



public interface ConnectionService {
	public Connection newConnectionRequest(Connection newConnection) throws Exception;

	public Customer searchCustomerByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException;

	public List<Connection> findActiveConnectionsByVillage(String village) throws NoSuchConnectionException;

	public List<Connection> findActiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException;

	public List<Connection> findActiveConnectionsByDistrict(String district) throws NoSuchConnectionException;

	public List<Connection> findActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException;
	
	//For incative connections
	
	public List<Connection> findInActiveConnectionsByVillage(String village) throws NoSuchConnectionException;

	public List<Connection> findInActiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException;

	public List<Connection> findInActiveConnectionsByDistrict(String district) throws NoSuchConnectionException;

	public List<Connection> findInActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException;

}
