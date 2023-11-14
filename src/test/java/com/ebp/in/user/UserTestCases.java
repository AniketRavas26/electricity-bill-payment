package com.ebp.in.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebp.in.entity.Customer;
import com.ebp.in.entity.User;
import com.ebp.in.exception.DuplicateCustomerException;
import com.ebp.in.exception.DuplicateUserException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.UserRepository;
import com.ebp.in.service.UserService;
import com.ebp.in.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserTestCases {
	
	@Mock
	private UserRepository userRepository;
	
	@Autowired
    @InjectMocks
	private static UserServiceImpl userService;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;


	List<User> userList;
    
    @BeforeEach
    public void setUp() {
    	
    userList = new ArrayList<>();
    user1 = new User((long) 1, "RAJU","raju@123");
    user2 = new User((long) 5, "RAMU","ramu@123");
    user3 = new User((long) 2, "PAVAN","pavan@123");

    user4 = new User((long) 3, "ANIKET","aniket@123");

    user5 = new User((long) 4, "DADAPEER","dadapeer@123");

    userList.add(user1);
    
    userList.add(user2);
    userList.add(user3);
    userList.add(user4);

    userList.add(user5);



    
    }
    
    @AfterEach
    public void tearDown() {
    user1 = user2 = user3=user4=user5=null;
    userList = null;
    
    }
    
    @Test
    void givenUserToAddShouldReturnAddedUser() throws  DuplicateUserException {
         //stubbing
         when(userRepository.save(any())).thenReturn(user1);
         userService.registerUser(user1);
         verify(userRepository,times(1)).save(any());
    }
    
    
    @Test
    void givenUserToAddShouldReturnAddedUser2() throws  DuplicateUserException {
         //stubbing
         when(userRepository.save(any())).thenReturn(user2);
         userService.registerUser(user2);
         verify(userRepository,times(1)).save(any());
    }
    
    @Test
    void givenUserToAddShouldReturnAddedUser3() throws  DuplicateUserException {
         //stubbing
         when(userRepository.save(any())).thenReturn(user3);
         userService.registerUser(user3);
         verify(userRepository,times(1)).save(any());
    }
    
    @Test
    void givenUserToAddShouldReturnAddedUser4() throws  DuplicateUserException {
         //stubbing
         when(userRepository.save(any())).thenReturn(user4);
         userService.registerUser(user4);
         verify(userRepository,times(1)).save(any());
    }
    
    @Test
    void givenUserToAddShouldReturnAddedUser5() throws  DuplicateUserException {
         //stubbing
         when(userRepository.save(any())).thenReturn(user5);
         userService.registerUser(user5);
         verify(userRepository,times(1)).save(any());
    }
    
}
