package com.ebp.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query(value = "select o from users o where o.userId=?1")
	Optional<User> readUserByUserId(int userId);

	@Query(value = "select o from users o where o.userName=?1 AND o.password=?2")
	Optional<User> readByUserNameAndPassword(String userName,String password);

	@Query(value = "select o from users o where o.userName=?1")
	Optional<User> readUserByUserName(String userName);

}
