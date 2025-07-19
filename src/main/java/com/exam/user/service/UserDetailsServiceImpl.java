package com.exam.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.user.entity.User;
import com.exam.user.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	Logger logger=LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
		User user = this.userRepository.findByUserName(username);
		
		if(user==null) {
			logger.info("UserName not found this name : {} ",username);
			throw new UsernameNotFoundException("No user found !!");
		}
		
		
		return user;
	}

}
