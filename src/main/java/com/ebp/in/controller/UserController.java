package com.ebp.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ebp.in.entity.User;
import com.ebp.in.exception.DuplicateUserException;
import com.ebp.in.exception.InvalidLoginCredentialException;
import com.ebp.in.exception.NoSuchUserException;
import com.ebp.in.service.UserService;



@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	

	
	

	@PostMapping(value = "/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws DuplicateUserException {
		User registeredUser = userService.registerUser(user);
		return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
	}

	@PostMapping(value = "/loginUser")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws InvalidLoginCredentialException {
		User registeredUser = userService.loginUser(user);
		return new ResponseEntity<User>(registeredUser, HttpStatus.OK);

	}

	@PostMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody User user) throws NoSuchUserException {
		userService.changePassword(user);
		String msg = "Password Updated Successfully for User:" + user;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping("/searchUserByUserName/{username}")
	public ResponseEntity<User> searchUserByUsername(@PathVariable String username) throws NoSuchUserException {
		User user = userService.searchUserByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/searchUserByUserId/{userId}")
	public ResponseEntity<User> searchUserByUserId(Integer userId) throws NoSuchUserException {
		User user = userService.searchUserByUserId(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("/forgotPassword/{username}")
	public ResponseEntity<?> forgotPassword(String username) throws Exception {
		String user ="Your password is : "+ userService.forgotPassword(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	

}