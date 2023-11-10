package com.ebp.in.service;

import com.ebp.in.entity.User;
import com.ebp.in.exception.DuplicateUserException;
import com.ebp.in.exception.InvalidLoginCredentialException;
import com.ebp.in.exception.NoSuchUserException;

public interface UserService {
	public User registerUser(User user) throws DuplicateUserException;
	public User loginUser(User user) throws InvalidLoginCredentialException;
	public User changePassword(User user) throws NoSuchUserException;
	public String forgotPassword(String username) throws Exception;

	public User searchUserByUsername(String username)throws NoSuchUserException;
	public User searchUserByUserId(int userId)throws NoSuchUserException;

}
