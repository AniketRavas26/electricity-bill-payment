package com.ebp.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebp.in.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> readByUserName(String userName);
	
	Optional<User> readUserByUserId(int userId);

	@Query(value = "select o from users o where o.userName=?1 AND o.password=?2")
	Optional<User> readByUserNameAndPassword(String userName,String password);

	@Query(value = "select o from users o where o.userName=?1")
	Optional<User> readUserByUserName(String name);

}
