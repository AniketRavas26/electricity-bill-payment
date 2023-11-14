package com.ebp.in.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.User;
import com.ebp.in.exception.DuplicateUserException;
import com.ebp.in.exception.InvalidLoginCredentialException;
import com.ebp.in.exception.NoSuchUserException;
import com.ebp.in.repository.UserRepository;
import com.ebp.in.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		Optional<User> obj=userRepository.readByUserName(user.getUserName());
		if (obj.isPresent()) {
			throw new DuplicateUserException("Already Exist");
		}else {
			return userRepository.save(user);
		}
		
	}

	@Override
	public User loginUser(User user) throws InvalidLoginCredentialException {
		// TODO Auto-generated method stub
		return ((Optional<User>) userRepository.readByUserNameAndPassword(user.getUserName(),user.getPassword()))
				.orElseThrow(() -> new InvalidLoginCredentialException("Invalid Credentials"));
		
	}

	@Override
	public User changePassword(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		User oldUser=null;
		Optional<User> obj=userRepository.readByUserName(user.getUserName());
		if(obj.isPresent()) {
			oldUser=obj.get();
			oldUser.setPassword(user.getPassword());
			userRepository.save(oldUser);
		}else {
			throw new NoSuchUserException("Not Exist");
		}
		return oldUser;
	}

	@Override
	public String forgotPassword(String username) throws Exception {
		// TODO Auto-generated method stub
		User password=((Optional<User>) userRepository.readByUserName( username)).orElseThrow(()->new Exception("no user found"));
		return password.getPassword();
	}

	@Override
	public User searchUserByUsername(String username) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return userRepository.readByUserName(username).orElseThrow(() -> new NoSuchUserException("No User Exists!"));
	}

	@Override
	public User searchUserByUserId(int userId) throws NoSuchUserException {
		// TODO Auto-generated method stub
		return userRepository.findById((long) userId).orElseThrow(() -> new NoSuchUserException("No User Exists!"));
	}
	

}
