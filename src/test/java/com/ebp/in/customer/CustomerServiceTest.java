package com.ebp.in.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import com.ebp.in.entity.Customer;
import com.ebp.in.exception.DuplicateCustomerException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.CustomerRepository;
import com.ebp.in.serviceimpl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
	
	 	@Mock
	    private CustomerRepository cutomerRepository;
	    @Autowired
	    @InjectMocks
	    private CustomerServiceImpl customerService;
	    private Customer customer1;
	    private Customer customer2;
	    private Customer customer3;
	    private Customer customer4;
	    private Customer customer5;
	    private Customer customer6;

	    List<Customer> customerList;
	    
	    @BeforeEach
	    public void setUp() {
	    	
	    customerList = new ArrayList<>();
	    customer1 = new Customer((long) 1, "RAJU","raju@123",2,(long)527688682,"Raju","Kumar","Bindi","826152826","raju@gmail.com","Male");
	    customer2 = new Customer((long) 5, "RAMU","ramu@123",3,(long)52738782,"Ramu","Kumar","Sindi","8262628826","ramu@gmail.com","Male");
	    customer3 = new Customer((long) 2, "PAVAN","pavan@123",4,(long)337688682,"Pavan","Kumar","gendi","8236822826","pavan@gmail.com","Male");

	    customer4 = new Customer((long) 3, "ANIKET","aniket@123",5,(long)833688682,"Aniket","Kumar","jedndi","3836152826","aniket@gmail.com","Male");

	    customer5 = new Customer((long) 4, "DADAPEER","dadapeer@123",6,(long)527388682,"Dadapeer","Kumar","Bdsbdi","878352826","dadapeer@gmail.com","Male");

	    customerList.add(customer1);
	    customerList.add(customer2);
	    customerList.add(customer3);
	    customerList.add(customer4);

	    customerList.add(customer5);



	    
	    }
	    
	    @AfterEach
	    public void tearDown() {
	    customer1 = customer2 = customer3=customer4=customer5=null;
	    customerList = null;
	    
	    }
	    
	    @Test
	    void givenCustomerToAddShouldReturnAddedCustomer() throws NoSuchCustomerException, DuplicateCustomerException{
	         //stubbing
	         when(cutomerRepository.save(any())).thenReturn(customer1);
	         customerService.registerCustomer(customer1);
	         verify(cutomerRepository,times(1)).save(any());
	    }
	    @Test
	    void givenCustomerToAddShouldReturnAddedCustomer2() throws NoSuchCustomerException, DuplicateCustomerException{
	         //stubbing
	         when(cutomerRepository.save(any())).thenReturn(customer2);
	         customerService.registerCustomer(customer2);
	         verify(cutomerRepository,times(1)).save(any());
	    }
	    
	    @Test
	    void givenCustomerToAddShouldReturnAddedCustomer3() throws NoSuchCustomerException, DuplicateCustomerException{
	         //stubbing
	         when(cutomerRepository.save(any())).thenReturn(customer3);
	         customerService.registerCustomer(customer3);
	         verify(cutomerRepository,times(1)).save(any());
	    }
	    
	    @Test
	    void givenCustomerToAddShouldReturnAddedCustomer4() throws NoSuchCustomerException, DuplicateCustomerException{
	         //stubbing
	         when(cutomerRepository.save(any())).thenReturn(customer4);
	         customerService.registerCustomer(customer4);
	         verify(cutomerRepository,times(1)).save(any());
	    }
	    
	    @Test
	    void givenCustomerToAddShouldReturnAddedCustomer5() throws NoSuchCustomerException, DuplicateCustomerException{
	         //stubbing
	         when(cutomerRepository.save(any())).thenReturn(customer5);
	         customerService.registerCustomer(customer5);
	         verify(cutomerRepository,times(1)).save(any());
	    }
	    
	    
	    
	    
	    
	    
	    @Test
	    public void givenIdThenShouldReturnCustomerOfThatMobileNumber() throws NoSuchCustomerException {
	       Mockito.when(cutomerRepository.readByMobileNumber(customer1.getMobileNumber())).thenReturn(Optional.ofNullable(customer1));
	       assertThat(customerService.searchCustomerByMobile(customer1.getMobileNumber())).isEqualTo(customer1);
	    }
	    

	    @Test
	    public void givenIdThenShouldReturnCustomerOfThatEmail() throws NoSuchCustomerException {
	       Mockito.when(cutomerRepository.readByEmail(customer1.getEmail())).thenReturn(Optional.ofNullable(customer1));
	       assertThat(customerService.searchCustomerByEmail(customer1.getEmail())).isEqualTo(customer1);
	    }

	    @Test
	    public void givenIdThenShouldReturnCustomerOfThatAdharNumber() throws NoSuchCustomerException {
	       Mockito.when(cutomerRepository.readByAdharNumber(customer1.getAdharNumber())).thenReturn(Optional.ofNullable(customer1));
	       assertThat(customerService.searchCustomerByAdhaar(customer1.getAdharNumber())).isEqualTo(customer1);
	    }
	    
	   
}
