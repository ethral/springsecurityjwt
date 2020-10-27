package com.sudam.securityjwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sudam.securityjwt.model.User;
import com.sudam.securityjwt.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        Optional<User> user =  userRepo.findByUserName(userName);
		
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName) ); 
		
		return user.map(MyUserDetails :: new).get();
	}
	
	
	

}
