package com.sudam.securityjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudam.securityjwt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String userName);

}
